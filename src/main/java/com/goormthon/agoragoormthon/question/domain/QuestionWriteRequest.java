package com.goormthon.agoragoormthon.question.domain;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionWriteRequest {
    Long readingBookId;
    String content;
}
