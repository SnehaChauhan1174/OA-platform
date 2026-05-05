package com.sneha.oa_platform.entity;

import com.sneha.oa_platform.enums.Verdict;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "submissions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "session_id", nullable = false)
    private OaSession session;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    // code for CODING, option label for MCQ
    @Column(columnDefinition = "TEXT")
    private String answer;

    // for coding submissions
    private String language;

    @Enumerated(EnumType.STRING)
    private Verdict verdict;

    // test cases passed out of total
    private Integer testCasesPassed;
    private Integer totalTestCases;

    private Integer score;

    @Column(nullable = false)
    private LocalDateTime submittedAt;

    @PrePersist
    protected void onCreate() {
        submittedAt = LocalDateTime.now();
    }
}
