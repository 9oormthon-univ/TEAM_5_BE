package com.goormthon.agoragoormthon.book.repository;

import com.goormthon.agoragoormthon.book.domain.Book;

import java.util.List;

public interface BookCustomRepository {

    List<Book> findRandomBooks();
}
