package com.goormthon.agoragoormthon.answer.service;

import com.goormthon.agoragoormthon.answer.domain.dto.AnswerWriteRequest;
import com.goormthon.agoragoormthon.answer.domain.dto.AnswerWriteResponse;
import com.goormthon.agoragoormthon.answer.domain.entity.Answer;
import com.goormthon.agoragoormthon.answer.domain.entity.AnswerRepository;
import com.goormthon.agoragoormthon.answer.domain.entity.CountAnswer;
import com.goormthon.agoragoormthon.answer.domain.entity.CountAnswerRepository;
import com.goormthon.agoragoormthon.memeber.domain.Member;
import com.goormthon.agoragoormthon.memeber.domain.MemberRepository;
import com.goormthon.agoragoormthon.question.domain.domain.Question;
import com.goormthon.agoragoormthon.question.domain.domain.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final CountAnswerRepository countAnswerRepository;
    private final MemberRepository memberRepository;

    public AnswerWriteResponse saveAnswer(AnswerWriteRequest answerDto) {
        Answer answer = Answer.builder()
                .memberId(answerDto.getMemberId())
                .questionId(answerDto.getQuestionId())
                .content(answerDto.getContent())
                .build();
        Answer newAnswer = this.answerRepository.save(answer);

        // validation
        Question question = questionRepository.findById(answerDto.getQuestionId())
                .orElseThrow(() -> new RuntimeException("존재하지 않는 발제입니다."));
        Member member = memberRepository.findById(answerDto.getMemberId())
                .orElseThrow(() -> new RuntimeException("존재하지 않는 사용자입니다."));
        AtomicReference<Long> countAnswerId = new AtomicReference<>();
        countAnswerRepository.findByQuestionId(answerDto.getQuestionId())
                .ifPresentOrElse(
                        // 값이 존재할 경우
                        existingCountAnswer -> {
                            existingCountAnswer.updateCount(existingCountAnswer.getCount() + 1);
                            countAnswerId.set(existingCountAnswer.getId());
                        },
                        // 값이 존재하지 않을 경우
                        () -> {
                            CountAnswer newCountAnswer = this.countAnswerRepository
                                    .save(CountAnswer.builder()
                                        .bookclubId(answerDto.getBookclubId())
                                        .questionId(answerDto.getQuestionId())
                                        .count(Long.valueOf(1))
                                        .build());
                            countAnswerId.set(newCountAnswer.getId());
                        }
                );

        CountAnswer countAnswer = countAnswerRepository.findById(countAnswerId.get())
                .orElseThrow(() -> new RuntimeException("댓글 갯수 세기 오류입니다."));

        return AnswerWriteResponse.toDto(question, newAnswer, member, countAnswer);
    }
}
