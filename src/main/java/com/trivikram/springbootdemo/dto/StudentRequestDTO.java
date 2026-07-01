package com.trivikram.springbootdemo.dto;

import java.util.List;

public class StudentRequestDTO {
    private String name;
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
