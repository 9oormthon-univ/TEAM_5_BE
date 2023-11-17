package com.goormthon.agoragoormthon.readingBook.repository;

import com.goormthon.agoragoormthon.readingBook.domain.ReadingBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingBookRepository extends JpaRepository<ReadingBook, Long> {



}
