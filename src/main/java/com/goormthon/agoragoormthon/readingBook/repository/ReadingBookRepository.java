package com.goormthon.agoragoormthon.readingBook.repository;

import com.goormthon.agoragoormthon.readingBook.domain.ReadingBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReadingBookRepository extends JpaRepository<ReadingBook, Long> {

    List<ReadingBook> findByBookClubId(Long bookClubId);

}
