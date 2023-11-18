package com.goormthon.agoragoormthon.question.service;

import com.goormthon.agoragoormthon.answer.domain.entity.AnswerRepository;
import com.goormthon.agoragoormthon.question.domain.domain.Question;
import com.goormthon.agoragoormthon.question.domain.domain.QuestionRepository;
import com.goormthon.agoragoormthon.question.domain.dto.*;
import com.goormthon.agoragoormthon.readingBook.domain.ReadingBook;
import com.goormthon.agoragoormthon.readingBook.repository.ReadingBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final ReadingBookRepository readingBookRepository;
    private final AnswerRepository answerRepository;

    public QuestionResponse saveQuestion(QuestionWriteRequest questionDto) {
        Question question = Question.builder()
                .readingBookId(questionDto.getReadingBookId())
                .content(questionDto.getContent())
                .build();
        Question newQuestion = this.questionRepository.save(question);

        return QuestionResponse.toDto(newQuestion);
    }

    @Transactional
    public QuestionResponse patchReview(Long questionId, QuestionPatchRequest patchRequest) {
        // validation
        Question question = questionRepository.findById(questionId).orElseThrow(() -> new RuntimeException("존재하지 않는 발제입니다."));
        ReadingBook readingBook = readingBookRepository.findById(patchRequest.getReadingBookId()).orElseThrow(() -> new RuntimeException("존재하지 않는 모임입니다."));

        question.updateContent(patchRequest.getContent());

    return QuestionResponse.toDto(question);
    }

    public QuestionDeleteResponse deleteQuestion(Long questionId) {
        // validation
        //
        questionRepository.deleteById(questionId);
        return QuestionDeleteResponse.builder().questionId(questionId).build();
    }

    public List<QuestionInfoResponse> getQuestionList(Long readingBookId) {
        return questionRepository.findByReadingBookId(readingBookId)
                .stream()
                .map(question -> {
                    QuestionInfoResponse questionInfoResponse = QuestionInfoResponse.builder()
                            .question(question.getContent())
                            .answer(answerRepository.findByQuestionId(question.getId())
                                    .stream()
                                    .map(answer -> {
                                        String newAnswer = answer.getContent();
                                        return newAnswer;
                                    }).collect(Collectors.toList()))
                            .build();
                    return questionInfoResponse;
                }).collect(Collectors.toList());
    }
}
