package com.fb_challenge.api.user.domain.entity;

import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private String email;
    private String cpf;
    private String password;

    public User(UUID id, String name, String email, String cpf, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.password = password;
    }
}
