package com.goormthon.agoragoormthon.cloud;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@Entity
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cloud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_club", nullable = false)
    private Long book_club_id;

    @Column(name = "style", nullable = false )
    private String style;


}
