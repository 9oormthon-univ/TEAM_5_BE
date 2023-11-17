package com.goormthon.agoragoormthon.readingBook.application;


import com.goormthon.agoragoormthon.book.domain.Book;
import com.goormthon.agoragoormthon.book.dto.BookListDto;
import com.goormthon.agoragoormthon.book.repository.BookRepository;
import com.goormthon.agoragoormthon.readingBook.domain.ReadingBook;
import com.goormthon.agoragoormthon.readingBook.dto.request.ReadingBookRequest;
import com.goormthon.agoragoormthon.readingBook.repository.ReadingBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReadingBookService {

    private final ReadingBookRepository readingBookRepository;
    private final BookRepository bookRepository;

    public void saveReadingBook(ReadingBookRequest request) {
        ReadingBook readingBook = ReadingBook.builder()
                .bookId(request.getBookId())
                .bookClubId(request.getBookClubId())
                .build();
        readingBookRepository.save(readingBook);
    }

    public List<BookListDto> getBooksByBookClubId(Long bookClubId) {

        List<ReadingBook> readingBooks = readingBookRepository.findByBookClubId(bookClubId);


        List<Long> bookIds = readingBooks.stream()
                .map(ReadingBook::getBookId)
                .collect(Collectors.toList());

        List<Book> books = bookRepository.findAllById(bookIds);

        return books.stream()
                .map(book -> new BookListDto(book.getId(), book.getTitle(), book.getAuthors(), book.getImgUrl()))
                .collect(Collectors.toList());

    }
    
}
