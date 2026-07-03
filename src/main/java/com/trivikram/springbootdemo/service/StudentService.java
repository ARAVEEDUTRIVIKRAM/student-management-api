package com.trivikram.springbootdemo.service;

import com.trivikram.springbootdemo.dto.BookResponseDTO;
import com.trivikram.springbootdemo.dto.StudentRequestDTO;
import com.trivikram.springbootdemo.dto.StudentResponseDTO;
import com.trivikram.springbootdemo.entity.Book;
import com.trivikram.springbootdemo.entity.Student;
import com.trivikram.springbootdemo.exception.StudentNotFoundException;
import com.trivikram.springbootdemo.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    //MANUALLY CREATING THE MODEL MAPPERS TO CONVERT ENTITY TO DTO AND DTO TO ENTITY

    //this method is used to convert the entity to ResponseDTO
    private StudentResponseDTO convertToResponse (Student student){
        StudentResponseDTO dto = new StudentResponseDTO();

        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());

        List<BookResponseDTO> books = student.getBooks()
                .stream()
                .map(book -> {
                    BookResponseDTO b = new BookResponseDTO();
                    b.setId(book.getId());
                    b.setTitle(book.getTitle());
                    return b;
                }).toList();

        dto.setBooks(books);
        return dto;
    }

    // THis method is used to convert the requestDTO to the entity class

    private Student convertToEntity(StudentRequestDTO requestDTO){
        Student student = new Student();
        student.setName(requestDTO.getName());
        student.setEmail(requestDTO.getEmail());

        List<Book> books = requestDTO.getBooks()
                .stream()
                .map(reqBook -> {
                    Book b = new Book();
                    b.setTitle(reqBook.getTitle());
                    b.setStudent(student);
                    return b;
                }).toList();
        student.setBooks(books);
        return student;

    }

    // The DTO'S Dosent perform CRUD Operations so that we need to converet DTOS TO ENTITIES TO PERFORM CRUD OPERATIONS USING REPOSITORY.
    // CREATE ( TO SAVE)
    public StudentResponseDTO createStudent(StudentRequestDTO dto){
        Student student = convertToEntity(dto);
        Student saved = studentRepository.save(student);
        return convertToResponse(saved);
    }
    // READ ( TO GET )
    // We written our own custom msg when id not found insted of inbult java error msges like NullPointerexception
    public StudentResponseDTO getStudent(Long id){
        Student student = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("student with id" + id + "not found"));
        return convertToResponse(student);
    }

    //UPDATE ( TO UPDATE)
    public StudentResponseDTO updateStudent(Long id, StudentRequestDTO dto){
        Student existing = studentRepository.findById(id).orElseThrow();

        existing.setName(dto.getName());
        existing.setEmail(dto.getEmail());

        //here we are updating the student details so we need to remove all previous books form the  student database.
        existing.getBooks().clear();

        List<Book> books = dto.getBooks().stream()
                .map(b -> {
                    Book book = new Book();
                    book.setTitle(b.getTitle());
                    book.setStudent(existing);
                    return book;
                }).toList();

        existing.setBooks(books);

        Student saved = studentRepository.save(existing);
        return convertToResponse(saved);
    }


















}
