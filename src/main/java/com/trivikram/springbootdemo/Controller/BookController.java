package com.trivikram.springbootdemo.Controller;

import com.trivikram.springbootdemo.entity.Book;
import com.trivikram.springbootdemo.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Books")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService){
        this.bookService=bookService;
    }

    @PostMapping
    public Book AddBook(@RequestBody Book book){
        return bookService.SaveBook(book);
    }

    @GetMapping
    public List<Book> getBook(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book){
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void DeleteBook(@PathVariable Long id){
        bookService.deleteBookById(id);
    }






}
