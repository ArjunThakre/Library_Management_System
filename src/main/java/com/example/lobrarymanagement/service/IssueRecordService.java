package com.example.lobrarymanagement.service;

import com.example.lobrarymanagement.entity.Book;
import com.example.lobrarymanagement.entity.IssueRecord;
import com.example.lobrarymanagement.entity.User;
import com.example.lobrarymanagement.repository.BookRepository;
import com.example.lobrarymanagement.repository.IssueRecordRepository;
import com.example.lobrarymanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class IssueRecordService {

    @Autowired
    private IssueRecordRepository issueRecordRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;


    public IssueRecord issueTheBook(Long bookId) {
        Book book=bookRepository.findById(bookId)
                .orElseThrow(()->new RuntimeException("Book Not Found"));

        if(book.getQuantity()<=0 || !book.isAvailable()){
            throw new RuntimeException("Book is Not Available");
        }
        String username= SecurityContextHolder.getContext().getAuthentication().getName();
        User user=userRepository.findByUsername(username)
                .orElseThrow(()-> new RuntimeException("User Not Found"));

        IssueRecord issueRecord=new IssueRecord();
        issueRecord.setIssueDate(LocalDate.now());
        issueRecord.setDueDate(LocalDate.now().plusDays(14));
        issueRecord.setIsReturned(false);
        issueRecord.setUser(user);
        issueRecord.setBook(book);

        book.setQuantity(book.getQuantity()-1);
        if (book.getQuantity()==0){
            book.setAvailable(false);
        }
        bookRepository.save(book);
      return  issueRecordRepository.save(issueRecord);

    }

    public IssueRecord returnTheBook(Long issueRecordId) {
        IssueRecord issueRecord=issueRecordRepository.findById(issueRecordId)
                .orElseThrow(()->new RuntimeException("Issue Record not found"));
        if (issueRecord.getIsReturned()){
            throw new RuntimeException("Book is Already Returned");
        }

        Book book=issueRecord.getBook();
        book.setQuantity(book.getQuantity()+1);
        book.setAvailable(true);
        bookRepository.save(book);
        issueRecord.setReturnDate(LocalDate.now());
        issueRecord.setIsReturned(true);

       return issueRecordRepository.save(issueRecord);

    }
}
