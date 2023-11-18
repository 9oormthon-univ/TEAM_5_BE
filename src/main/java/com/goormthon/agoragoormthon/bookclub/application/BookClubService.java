package com.goormthon.agoragoormthon.bookclub.application;

import com.goormthon.agoragoormthon.book.dto.BookListDto;
import com.goormthon.agoragoormthon.bookclub.domain.BookClub;
import com.goormthon.agoragoormthon.bookclub.dto.BookClubInfo;
import com.goormthon.agoragoormthon.bookclub.dto.request.BookClubCreateDto;
import com.goormthon.agoragoormthon.bookclub.repository.BookClubRepository;
import com.goormthon.agoragoormthon.cloud.application.CloudService;
import com.goormthon.agoragoormthon.cloud.dto.CloudResponseDto;
import com.goormthon.agoragoormthon.readingBook.application.ReadingBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookClubService {

    private final BookClubRepository bookClubRepository;

    private final ReadingBookService readingBookService;
    private final CloudService cloudService;

    public BookClubInfo getBooksAndCloudsByBookClubId(Long bookClubId) {
        List<BookListDto> books = readingBookService.getBooksByBookClubId(bookClubId);
        List<CloudResponseDto> clouds = cloudService.getCloudsByBookClubId(bookClubId);

        return new BookClubInfo(books, clouds);
    }

    public BookClub createBookClub(BookClubCreateDto bookClubCreateDto) {
        BookClub bookClub = BookClub.builder()
                .title(bookClubCreateDto.getTitle())
                .overview(bookClubCreateDto.getOverview())
                .build();
        return bookClubRepository.save(bookClub);
    }

    public List<BookClub> getAllBookClubs() {
        return bookClubRepository.findAll();
    }


}
