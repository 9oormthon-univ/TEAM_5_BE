package com.goormthon.agoragoormthon.readingBook.application;


import com.goormthon.agoragoormthon.readingBook.domain.ReadingBook;
import com.goormthon.agoragoormthon.readingBook.dto.request.ReadingBookRequest;
import com.goormthon.agoragoormthon.readingBook.repository.ReadingBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor
public class ReadingBookService {

    private final ReadingBookRepository readingBookRepository;

    public void saveReadingBook(ReadingBookRequest request) {
        ReadingBook readingBook = ReadingBook.builder()
                .bookId(request.getBookId())
                .bookClubId(request.getBookClubId())
                .build();
        readingBookRepository.save(readingBook);
    }
    
}
