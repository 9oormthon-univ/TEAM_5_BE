package com.goormthon.agoragoormthon.bookclub.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookClubCreateDto {

    private String title;
    private String overview;

}