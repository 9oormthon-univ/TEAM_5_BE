package com.goormthon.agoragoormthon.question.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@Entity
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "readingBook_id", nullable = false)
    private Long readingBookId;

    @Column(name = "content", nullable = false)
    private String content;

    public void updateContent(String content) {
        this.content = content;}
}
