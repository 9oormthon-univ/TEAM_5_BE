package com.goormthon.agoragoormthon.answer.domain.dto;

import com.goormthon.agoragoormthon.answer.domain.entity.Answer;
import com.goormthon.agoragoormthon.answer.domain.entity.CountAnswer;
import com.goormthon.agoragoormthon.memeber.domain.Member;
import com.goormthon.agoragoormthon.question.domain.domain.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerWriteResponse {
    Long questionId;
    String questionContent;
    Long answerId;
    String answerContent;
    Long memberId;
    String memberName;
    Long countAnswer;

    public static AnswerWriteResponse toDto(Question question, Answer answer, Member member, CountAnswer countAnswer) {
        return AnswerWriteResponse.builder()
                .questionId(question.getId())
                .questionContent(question.getContent())
                .answerId(answer.getId())
                .answerContent(answer.getContent())
                .memberId(member.getId())
                .memberName(member.getName())
                .countAnswer(countAnswer.getCount())
                .build();

    }
}
