package com.goormthon.agoragoormthon.answer.controller;

import com.goormthon.agoragoormthon.answer.domain.dto.AnswerWriteRequest;
import com.goormthon.agoragoormthon.answer.domain.dto.AnswerWriteResponse;
import com.goormthon.agoragoormthon.answer.service.AnswerService;
import com.goormthon.agoragoormthon.global.response.ResponseType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/answer")
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping
    public ResponseType<AnswerWriteResponse> writeAnswer(@RequestBody AnswerWriteRequest answerDto) {
        return ResponseType.createSuccessWithData(answerService.saveAnswer(answerDto));
    }
}
