package com.goormthon.agoragoormthon.bookclub.application;

import com.goormthon.agoragoormthon.book.dto.BookListDto;
import com.goormthon.agoragoormthon.bookclub.dto.BookClubInfo;
import com.goormthon.agoragoormthon.cloud.application.CloudService;
import com.goormthon.agoragoormthon.cloud.dto.CloudResponseDto;
import com.goormthon.agoragoormthon.readingBook.application.ReadingBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookClubService {

    private final ReadingBookService readingBookService;
    private final CloudService cloudService;

    public BookClubInfo getBooksAndCloudsByBookClubId(Long bookClubId) {
        List<BookListDto> books = readingBookService.getBooksByBookClubId(bookClubId);
        List<CloudResponseDto> clouds = cloudService.getCloudsByBookClubId(bookClubId);

        return new BookClubInfo(books, clouds);

    }


}
