package com.goormthon.agoragoormthon.readingBook.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReadingBookRequest {
    private Long bookId;
    private Long bookClubId;
}
