package com.goormthon.agoragoormthon.question.domain;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionPatchRequest {
    Long questionId;
    Long readingBookId;
    String content;
}
