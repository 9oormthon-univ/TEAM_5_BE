package com.goormthon.agoragoormthon.bookclub.presentation;

import com.goormthon.agoragoormthon.bookclub.application.BookClubService;
import com.goormthon.agoragoormthon.bookclub.domain.BookClub;
import com.goormthon.agoragoormthon.bookclub.dto.BookClubInfo;
import com.goormthon.agoragoormthon.bookclub.dto.request.BookClubCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @PostMapping("/make")
    public ResponseEntity<BookClub> createBookClub(@RequestBody BookClubCreateDto bookClubCreateDto) {
        BookClub bookClub = bookClubService.createBookClub(bookClubCreateDto);
        return ResponseEntity.ok(bookClub);
    }

    @GetMapping
    public ResponseEntity<List<BookClub>> getAllBookClubs() {
        List<BookClub> bookClubs = bookClubService.getAllBookClubs();
        return ResponseEntity.ok(bookClubs);
    }


}

