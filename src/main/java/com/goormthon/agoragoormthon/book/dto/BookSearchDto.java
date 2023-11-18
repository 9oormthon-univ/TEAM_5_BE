package com.goormthon.agoragoormthon.book.dto;


import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookSearchDto {
    private Long id;
    private String title;
    private String authors;
    private String publisher;
    private String imgUrl;


}


