package com.example.preddema.Model;

public enum Role {
    USER("Пользователь"),
    ADMIN("Админисратор");

    private final String name;

    Role(String name) {this.name = name;}
}
