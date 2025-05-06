package com.example.lobrarymanagement.service;

import com.example.lobrarymanagement.DTO.BookDTO;
import com.example.lobrarymanagement.entity.Book;
import com.example.lobrarymanagement.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
      return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        Book book=bookRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Book Not Found"));
        return book;
    }

    public Book addBook(BookDTO bookDTO) {
        Book book=new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setQuantity(bookDTO.getQuantity());
        book.setIsbn(bookDTO.getIsbn());
        book.setAvailable(bookDTO.isAvailable());

       return bookRepository.save(book);
    }

    public Book updateBook(Long id, BookDTO bookDTO) {
        Book oldbook=bookRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Book is Not Found"));
        oldbook.setTitle(bookDTO.getTitle());
        oldbook.setAuthor(bookDTO.getAuthor());
        oldbook.setQuantity(bookDTO.getQuantity());
        oldbook.setIsbn(bookDTO.getIsbn());
        oldbook.setAvailable(bookDTO.isAvailable());

       return bookRepository.save(oldbook);
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
