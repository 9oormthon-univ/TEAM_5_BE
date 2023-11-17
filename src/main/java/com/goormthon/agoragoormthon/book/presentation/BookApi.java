package com.goormthon.agoragoormthon.book.presentation;


import com.goormthon.agoragoormthon.book.application.BookService;
import com.goormthon.agoragoormthon.book.dto.BookListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookApi {

    private final BookService bookService;


    @GetMapping("/random")
    public ResponseEntity<List<BookListDto>> getRandomBooks() {
        List<BookListDto> books = bookService.findRandomBooks();
        return ResponseEntity.ok(books);
    }

}
