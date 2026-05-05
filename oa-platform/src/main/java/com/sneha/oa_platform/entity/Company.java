package com.sneha.oa_platform.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name="companies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Integer totalTimeMins;

    @Column(nullable = false)
    private Integer codingCount;

    @Column(nullable = false)
    private Integer mcqCount;

    private Integer sqlCount;

    private Integer aptitudeCount;

    @Column(columnDefinition = "TEXT")
    private String description;
}
