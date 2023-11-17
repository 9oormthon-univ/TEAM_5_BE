package com.goormthon.agoragoormthon.book.repository;

import com.goormthon.agoragoormthon.book.domain.Book;
import com.goormthon.agoragoormthon.readingBook.domain.ReadingBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>,BookCustomRepository {

}
