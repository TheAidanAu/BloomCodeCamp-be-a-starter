package com.hcc.entities;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Authority implements GrantedAuthority {
    private Long id;
    private String authority;
    @ManyToOne
    private User user; //Many to one annotation

    public Authority() {
    }

    public Authority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
