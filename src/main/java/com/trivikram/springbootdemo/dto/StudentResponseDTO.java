package com.trivikram.springbootdemo.dto;

import java.util.List;

public class StudentResponseDTO {
    private Long id;
    private String name;
    private String email;
    private List<BookResponseDTO> books;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookResponseDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookResponseDTO> books) {
        this.books = books;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
