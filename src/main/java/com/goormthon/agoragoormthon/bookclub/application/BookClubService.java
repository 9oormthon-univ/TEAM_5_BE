package com.goormthon.agoragoormthon.bookclub.application;

import com.goormthon.agoragoormthon.book.dto.BookListDto;
import com.goormthon.agoragoormthon.bookclub.domain.BookClub;
import com.goormthon.agoragoormthon.bookclub.dto.BookClubInfo;
import com.goormthon.agoragoormthon.bookclub.dto.request.BookClubCreateDto;
import com.goormthon.agoragoormthon.bookclub.repository.BookClubRepository;
import com.goormthon.agoragoormthon.cloud.application.CloudService;
import com.goormthon.agoragoormthon.cloud.dto.CloudResponseDto;
import com.goormthon.agoragoormthon.readingBook.application.ReadingBookService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.goormthon.agoragoormthon.bookclub.domain.QBookClub.bookClub;

@Service
@RequiredArgsConstructor
public class BookClubService {

    private final BookClubRepository bookClubRepository;
    private final ReadingBookService readingBookService;
    private final CloudService cloudService;

    public BookClubInfo getBooksAndCloudsByBookClubId(Long bookClubId) {

        BookClub bookClub = bookClubRepository.findById(bookClubId)
                .orElseThrow(() -> new EntityNotFoundException("BookClub not found with id: " + bookClubId));

        List<BookListDto> books = readingBookService.getBooksByBookClubId(bookClubId);
        List<CloudResponseDto> clouds = cloudService.getCloudsByBookClubId(bookClubId);

        return new BookClubInfo(bookClub.getTitle(),books, clouds);
    }

    public BookClub createBookClub(BookClubCreateDto bookClubCreateDto) {
        BookClub bookClub = BookClub.builder()
                .title(bookClubCreateDto.getTitle())
                .overview(bookClubCreateDto.getOverview())
                .build();
        return bookClubRepository.save(bookClub);
    }


}
