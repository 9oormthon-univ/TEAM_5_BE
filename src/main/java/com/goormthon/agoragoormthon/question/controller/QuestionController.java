package com.goormthon.agoragoormthon.question.controller;

import com.goormthon.agoragoormthon.global.response.ResponseType;
import com.goormthon.agoragoormthon.question.domain.dto.QuestionDeleteResponse;
import com.goormthon.agoragoormthon.question.domain.dto.QuestionPatchRequest;
import com.goormthon.agoragoormthon.question.domain.dto.QuestionWriteRequest;
import com.goormthon.agoragoormthon.question.domain.dto.QuestionResponse;
import com.goormthon.agoragoormthon.question.domain.dto.QuestionInfoResponse;
import com.goormthon.agoragoormthon.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/question")
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping
    public ResponseType<QuestionResponse> writeQuestion(@RequestBody QuestionWriteRequest questionDto) {
        return ResponseType.createSuccessWithData(questionService.saveQuestion(questionDto));
    }

    @PatchMapping("/{questionId}")
    public ResponseType<QuestionResponse> patchQuestion(@PathVariable Long questionId, @RequestBody QuestionPatchRequest patchRequest) {
        return ResponseType.createSuccessWithData(questionService.patchReview(questionId, patchRequest));
    }

    @DeleteMapping("/{questionId}")
    public ResponseType<QuestionDeleteResponse> deleteQuestion(@PathVariable Long questionId) {
        return ResponseType.createSuccessWithData(questionService.deleteQuestion(questionId));
    }

    @GetMapping("/list")
    public ResponseType<List<QuestionInfoResponse>> getQuestionList(@RequestParam("readingBookId") Long readingBookId) {
        return ResponseType.createSuccessWithData(questionService.getQuestionList(readingBookId));
    }
}
