package com.goormthon.agoragoormthon.book.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookListDto {
    private Long id;
    private String title;
    private String authors;
    private String imgUrl;

    @QueryProjection
    public BookListDto(Long id,String title, String authors, String imgUrl) {

        this.id = id;
        this.title = title;
        this.authors = authors;
        this.imgUrl = imgUrl;
    }

}

