package com.goormthon.agoragoormthon.book.application;

import com.goormthon.agoragoormthon.book.dto.BookListDto;
import com.goormthon.agoragoormthon.book.repository.BookRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    @Transactional(readOnly = true)
    public List<BookListDto> findRandomBooks() {
        return bookRepository.findRandomBooks().stream()
                .map(book -> new BookListDto(book.getId(), book.getTitle(), book.getAuthors(), book.getImgUrl()))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<BookListDto> searchBooks(String keyword){
        return bookRepository.searchBooks(keyword).stream()
                .map(book -> new BookListDto(book.getId(), book.getTitle(), book.getAuthors(), book.getImgUrl()))
                .collect(Collectors.toList());
    }

}
