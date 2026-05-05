package com.sneha.oa_platform.entity;

import com.sneha.oa_platform.enums.DifficultyMode;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "custom_oa_configs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CustomOaConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private Integer totalTimeMins;

    @Column(nullable = false)
    private Integer codingCount;

    private Integer mcqCount;

    private Integer sqlCount;

    private Integer aptitudeCount;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DifficultyMode difficultyMode;

    // comma separated topics user selected
    // e.g. "Arrays,DP,Graphs"
    @Column(columnDefinition = "TEXT")
    private String selectedTopics;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }


}
