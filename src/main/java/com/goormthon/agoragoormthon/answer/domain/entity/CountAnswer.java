package com.goormthon.agoragoormthon.answer.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@Entity
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CountAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bookclub_id", nullable = false)
    private Long bookclubId;

    @Column(name = "question_id", nullable = false)
    private Long questionId;

    @Column(name = "count", nullable = false)
    private Long count;

    public void updateCount(Long count) {
        this.count = count;
    }
}