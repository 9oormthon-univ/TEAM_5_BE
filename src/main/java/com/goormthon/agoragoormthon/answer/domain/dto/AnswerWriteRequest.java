package com.goormthon.agoragoormthon.answer.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnswerWriteRequest {
    Long questionId;
    Long bookclubId;
    Long memberId;
    String content;
}
