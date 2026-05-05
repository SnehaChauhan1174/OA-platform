package com.sneha.oa_platform.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "company_question_tags")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CompanyQuestionTag {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    // higher weight = this question appears more often in this company's OA
    @Column(nullable = false)
    private Integer weight;

}
