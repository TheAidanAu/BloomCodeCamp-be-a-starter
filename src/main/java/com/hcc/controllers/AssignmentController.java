package com.hcc.controllers;

import com.hcc.entities.Assignment;
import com.hcc.entities.User;
import com.hcc.exceptions.ResourceNotFoundException;
import com.hcc.repositories.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/assignments/")
public class AssignmentController {

    @Autowired
    AssignmentRepository assignmentRepository;

    // Endpoint to retrieve a list of assignment which a user is currently working on
    @GetMapping
    public ResponseEntity<List<Assignment>> findAssignmentsByUser(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(this.assignmentRepository.findByUser(user));
    }

    // Endpoint to retrieve an assignment by its assignment ID
    @GetMapping("{id}")
    public ResponseEntity<Assignment> findAnAssignmentById (@AuthenticationPrincipal User user,
                                                            @PathVariable Long id) {
        // Use an Optional type in case there may or may not be such assignment for the id
        Optional<Assignment> assignment = this.assignmentRepository.findById(id);

        // If the assignment is present, return it as a response entity with an OK/200 status
        if (assignment.isPresent()) {
            return ResponseEntity.ok(assignment.get());
            // if not, we will throw a ResourceNotFoundException
        } else {
            throw new ResourceNotFoundException("There's no such assignment with the id: " + id);
     }
    }

    // Endpoint to save an assignment to the database
    @PostMapping
    public ResponseEntity<Assignment> saveAnAssignment(@AuthenticationPrincipal User user,
                                                       @RequestBody Assignment newAssignment) {
        return ResponseEntity.ok(this.assignmentRepository.save(newAssignment));
    }

    // This EndPoint can be used for a Reviewer to **claim** an assignment to review
    // Only a Reviewer has the authority to update an assignment's reviewer
    @PutMapping("{id}")
    public ResponseEntity<Assignment> updateAssignment(@AuthenticationPrincipal User user,
                                       @PathVariable Long id) {

        Assignment assignmentToUpdate = this.assignmentRepository.findById(id).get();

        // If this assignment currently does NOT have a reviewer
        if (assignmentToUpdate.getCodeReviewer() == null) {
            // we will assign the reviewer user to review this assignment
            assignmentToUpdate.setCodeReviewer(user);
        }

        return ResponseEntity.ok(this.assignmentRepository.save(assignmentToUpdate));
    }

    // Endpoint to delete an assignment from the database
    // Since a deleted item/assignment cannot be returned, we'll return a status message instead
    @DeleteMapping("{id}")
    public String deleteAnExistingAssignment(@AuthenticationPrincipal User user,
                                             @PathVariable Long id) {
        Optional<Assignment> assignmentToDelete = this.assignmentRepository.findById(id);

        // If the assignment is present, we will attempt to delete
        // and return a successful status message
        if (assignmentToDelete.isPresent()) {
            this.assignmentRepository.delete(assignmentToDelete.get());
            return String.format("The Assignment with the id %s has been successfully deleted.", id);
            // if not, we will return an error message
        } else {
            return "There's no such assignment with the id: " + id;
        }
    }
}
