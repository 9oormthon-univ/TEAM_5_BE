package com.goormthon.agoragoormthon.readingBook.presentation;


import com.goormthon.agoragoormthon.common.dto.ResponseDto;
import com.goormthon.agoragoormthon.readingBook.application.ReadingBookService;
import com.goormthon.agoragoormthon.readingBook.dto.request.ReadingBookRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/readingBooks")
@RequiredArgsConstructor
public class ReadingBookApi {

    private final ReadingBookService readingBookService;

    @PostMapping("/save")
    public ResponseEntity<Void> addReadingBook(@RequestBody ReadingBookRequest request) {

        readingBookService.saveReadingBook(request);
        return ResponseDto.noContent();

    }
}
