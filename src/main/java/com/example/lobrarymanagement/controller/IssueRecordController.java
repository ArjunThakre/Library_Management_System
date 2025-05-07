package com.example.lobrarymanagement.controller;

import com.example.lobrarymanagement.entity.IssueRecord;
import com.example.lobrarymanagement.service.IssueRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/issuerecords")
public class IssueRecordController {

    @Autowired
    private IssueRecordService issueRecordService;


    @PostMapping("/issuethebook/bookid")
    public ResponseEntity<IssueRecord> issueTheBook(@PathVariable Long bookId){
        return ResponseEntity.ok(issueRecordService.issueTheBook(bookId));
    }

    @PostMapping("/reurnthebook/{issuerecordid}")
    public ResponseEntity<IssueRecord> returnTheBook(@PathVariable Long issueRecordId){
        return  ResponseEntity.ok(issueRecordService.returnTheBook(issueRecordId));
    }
}
