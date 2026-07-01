package com.trivikram.springbootdemo.service;

import com.trivikram.springbootdemo.entity.Book;
import com.trivikram.springbootdemo.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    public Book SaveBook(Book book){
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBookById(Long id){
        return bookRepository.findById(id).orElse(null);
    }

    public Book updateBook(Long id, Book newBook){
        Book existing = bookRepository.findById(id).orElse(null);

        if(existing != null){
            existing.setTitle(newBook.getTitle());
            existing.setAuthor(newBook.getAuthor());
            return bookRepository.save(existing);
        }
        return null;
    }

    public void deleteBookById(Long id){
        bookRepository.deleteById(id);
    }
}
