package com.goormthon.agoragoormthon.book.repository.impl;

import com.goormthon.agoragoormthon.book.domain.Book;
import com.goormthon.agoragoormthon.book.repository.BookCustomRepository;
import com.goormthon.agoragoormthon.book.repository.BookRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static com.goormthon.agoragoormthon.book.domain.QBook.book;

@Repository
@RequiredArgsConstructor
public class BookCustomRepositoryImpl implements BookCustomRepository {

    private final JPAQueryFactory queryFactory;
    @Override
    public List<Book> findRandomBooks() {

        List<Book> books = queryFactory
                .selectFrom(book)
                .orderBy(book.id.asc())
                .fetch();

        Collections.shuffle(books, new Random());
        return books.subList(0, Math.min(10, books.size()));
    }

    @Override
    public List<Book> searchBooks(String keyword){

        return queryFactory
                .selectFrom(book)
                .where(titleContains(keyword).or(authorContains(keyword)))
                .fetch();
    }
    private BooleanExpression titleContains(String title) {
        return title != null ? book.title.contains(title) : null;
    }

    private BooleanExpression authorContains(String author) {
        return author != null ? book.authors.contains(author) : null;
    }

}
