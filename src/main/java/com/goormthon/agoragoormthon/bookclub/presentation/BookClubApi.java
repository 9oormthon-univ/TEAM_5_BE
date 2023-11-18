package com.goormthon.agoragoormthon.bookclub.presentation;

import com.goormthon.agoragoormthon.bookclub.application.BookClubService;
import com.goormthon.agoragoormthon.bookclub.dto.BookClubInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/bookClubs")
@RequiredArgsConstructor
public class BookClubApi {

    private final BookClubService bookClubService;

    @GetMapping("/{bookClubId}")
    public ResponseEntity<BookClubInfo> getBooksAndCloudsByBookClubId(@PathVariable Long bookClubId) {
        BookClubInfo combinedResponse = bookClubService.getBooksAndCloudsByBookClubId(bookClubId);
        return ResponseEntity.ok(combinedResponse);
    }


}

