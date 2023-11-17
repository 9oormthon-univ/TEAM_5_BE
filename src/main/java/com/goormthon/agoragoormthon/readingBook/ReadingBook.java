package com.goormthon.agoragoormthon.readingBook;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@Entity
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReadingBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_club", nullable = false)
    private Long book_club_id;

    @Column(name = "book_id", nullable = false)
    private Long book_id;


}
