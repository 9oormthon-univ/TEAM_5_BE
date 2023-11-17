package com.goormthon.agoragoormthon.question.service;

import com.goormthon.agoragoormthon.question.domain.*;
import com.goormthon.agoragoormthon.readingBook.domain.ReadingBook;
import com.goormthon.agoragoormthon.readingBook.repository.ReadingBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final ReadingBookRepository readingBookRepository;

    public QuestionResponse saveQuestion(QuestionWriteRequest questionDto) {
        Question question = Question.builder()
                .content(questionDto.getContent())
                .build();
        Question newQuestion = this.questionRepository.save(question);
        // validation
        ReadingBook readingBook = readingBookRepository.findById(questionDto.getReadingBookId()).orElseThrow(() -> new RuntimeException("존재하지 않는 책입니다."));

        return QuestionResponse.toDto(newQuestion, readingBook);
    }

    @Transactional
    public QuestionResponse patchReview(Long questionId, QuestionPatchRequest patchRequest) {
        // validation
        Question question = questionRepository.findById(questionId).orElseThrow(() -> new RuntimeException("존재하지 않는 발제입니다."));
        ReadingBook readingBook = readingBookRepository.findById(patchRequest.getReadingBookId()).orElseThrow(() -> new RuntimeException("존재하지 않는 모임입니다."));

        question.updateContent(patchRequest.getContent());

    return QuestionResponse.toDto(question, readingBook);
    }

    public QuestionDeleteResponse deleteQuestion(Long questionId) {
        // validation
        //
        questionRepository.deleteById(questionId);
        return QuestionDeleteResponse.builder().questionId(questionId).build();
    }
}
