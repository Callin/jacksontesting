package com.example.jacksontesting.dto;

import com.example.jacksontesting.annotation.JsonPropertyEs;

public class JackDto {

    @JsonPropertyEs("NAME")
    private String name;

    @JsonPropertyEs("EMAIL")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "JackDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
