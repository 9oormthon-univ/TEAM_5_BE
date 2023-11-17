package com.goormthon.agoragoormthon.answer.domain.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountAnswerRepository extends JpaRepository<CountAnswer, Long> {
    Optional<CountAnswer> findByQuestionId(Long questionId);
}
