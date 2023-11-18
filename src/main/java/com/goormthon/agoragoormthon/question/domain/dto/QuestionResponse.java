package com.goormthon.agoragoormthon.question.domain.dto;

import com.goormthon.agoragoormthon.question.domain.domain.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponse {
    Long questionId;
    Long readingBookId;
    String content;

    public static QuestionResponse toDto(Question question) {
        return QuestionResponse.builder()
                .questionId(question.getId())
                .readingBookId(question.getId())
                .content(question.getContent())
                .build();
    }
}
