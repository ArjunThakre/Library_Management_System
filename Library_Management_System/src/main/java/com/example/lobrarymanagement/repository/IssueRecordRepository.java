package com.example.lobrarymanagement.repository;

import com.example.lobrarymanagement.entity.IssueRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRecordRepository extends JpaRepository<IssueRecord,Long> {
}
