package com.hcc.entities;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class User {

    private Long id;
    private Date cohortStartDate;
    private String username;
    private String password;
    private List<Authority> authorities;

    public User() {
    }

    public User(Long id, Date cohortStartDate, String username, String password, List<Authority> authorities) {
        this.id = id;
        this.cohortStartDate = cohortStartDate;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCohortStartDate() {
        return cohortStartDate;
    }

    public void setCohortStartDate(Date cohortStartDate) {
        this.cohortStartDate = cohortStartDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getId(), user.getId()) && Objects.equals(getCohortStartDate(), user.getCohortStartDate()) && Objects.equals(getUsername(), user.getUsername()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getAuthorities(), user.getAuthorities());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCohortStartDate(), getUsername(), getPassword(), getAuthorities());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", cohortStartDate=" + cohortStartDate +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + authorities +
                '}';
    }
}
