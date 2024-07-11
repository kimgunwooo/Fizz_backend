package com.fizz.fizz_server.domain.challenge.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public enum Category {

    // 우선 예시로만..
    Health("헬스"),
    Musical_Instruments("악기"),
    Books("책"),
    Asceticism("금욕"),
    Sports("스포츠"),
    Cooking("요리"),
    Art("예술"),
    Technology("기술"),
    Gardening("원예"),
    Travel("여행");

    String description;
}