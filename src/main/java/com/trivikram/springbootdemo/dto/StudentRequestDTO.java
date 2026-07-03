package com.trivikram.springbootdemo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;

import java.util.List;

public class StudentRequestDTO {

    @NotNull(message = "Name cannot be null")
    @Size(min = 3, message = "Name must have at least 3 characters")
    private String name;

    @NotNull(message = "Email must not be null")
    @Email(message = "Email format is invalid")
    private String email;
    private List<BookRequestDTO> books;

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

    public List<BookRequestDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookRequestDTO> books) {
        this.books = books;
    }
}
