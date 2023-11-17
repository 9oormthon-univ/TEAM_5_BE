package com.goormthon.agoragoormthon.book.repository;

import com.goormthon.agoragoormthon.book.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>,BookCustomRepository {

}
