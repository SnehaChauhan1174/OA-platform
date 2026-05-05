package com.sneha.oa_platform.entity;

import com.sneha.oa_platform.enums.Difficulty;
import com.sneha.oa_platform.enums.QuestionType;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "questions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private QuestionType type;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @Column(nullable = false)
    private String topic;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    // for MCQ — stores correct option label (A, B, C, D)
    private String correctAnswer;

    // for CODING — stores expected output for basic test case
    @Column(columnDefinition = "TEXT")
    private String sampleInput;

    @Column(columnDefinition = "TEXT")
    private String sampleOutput;

    // MCQ options — only populated for MCQ type questions
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<McqOption> options;


}
