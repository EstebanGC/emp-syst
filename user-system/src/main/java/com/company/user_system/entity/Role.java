package com.company.user_system.entity;

import jakarta.persistence.*;

import java.util.List;

public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique=true)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
