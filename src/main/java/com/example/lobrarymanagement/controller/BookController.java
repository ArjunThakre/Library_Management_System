package com.example.lobrarymanagement.controller;

import com.example.lobrarymanagement.DTO.BookDTO;
import com.example.lobrarymanagement.entity.Book;
import com.example.lobrarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/getallbooks")
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/getbookbyid/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @PostMapping("/addbook")
    @PreAuthorize("hasRole('Admin')")
    public  ResponseEntity<Book> addBook(@RequestBody BookDTO bookDTO){
        return  ResponseEntity.ok(bookService.addBook(bookDTO));
    }

    @PutMapping("/updatebook/{id}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO){
        return  ResponseEntity.ok(bookService.updateBook(id,bookDTO));
    }

    @DeleteMapping("/deletebook/{id}")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        bookService.deleteBookById(id);
        return ResponseEntity.ok().build();
    }
}
