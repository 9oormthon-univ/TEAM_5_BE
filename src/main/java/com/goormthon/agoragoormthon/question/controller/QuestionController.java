package com.goormthon.agoragoormthon.question.controller;

import com.goormthon.agoragoormthon.global.response.ResponseType;
import com.goormthon.agoragoormthon.question.domain.QuestionDeleteResponse;
import com.goormthon.agoragoormthon.question.domain.QuestionPatchRequest;
import com.goormthon.agoragoormthon.question.domain.QuestionWriteRequest;
import com.goormthon.agoragoormthon.question.domain.QuestionResponse;
import com.goormthon.agoragoormthon.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
}
