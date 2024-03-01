package com.hcc.entities;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class Authority implements GrantedAuthority {
    private Long id;

    @Column(name = "authority")
    private String authority;

    @ManyToOne(optional = false)
    private User user; //Many to one annotation

    public Authority() {
    }

    public Authority(String authority) {
        this.authority = authority;
    }

    public Authority(String authority, User user) {
        this.authority = authority;
        this.user = user;
    }
    @Override
    public String getAuthority() {
        return authority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
