package com.goormthon.agoragoormthon.bookclub.dto;

import com.goormthon.agoragoormthon.book.dto.BookListDto;
import com.goormthon.agoragoormthon.cloud.dto.CloudResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class BookClubInfo {

    private String title;
    private List<BookListDto> books;
    private List<CloudResponseDto> clouds;


}
