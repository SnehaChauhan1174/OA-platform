package com.sneha.oa_platform.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "mcq_options")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class McqOption {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    // A, B, C, D
    @Column(nullable = false)
    private String optionLabel;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String optionText;

}
