package com.example.spring_mvc_study1_mvc.basic;

import lombok.Data;

@Data
// @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor 등을 모두 지원함 -> @Data
public class HelloData {
    private String username;
    private int age;
}
