package com.sneha.oa_platform.entity;

import com.sneha.oa_platform.enums.SessionStatus;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "oa_sessions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class OaSession {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // null if custom OA
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    // null if company OA
    @ManyToOne
    @JoinColumn(name = "custom_config_id")
    private CustomOaConfig customConfig;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SessionStatus status;

    @Column(nullable = false)
    private LocalDateTime startedAt;

    // server enforced timer — never trust client
    @Column(nullable = false)
    private LocalDateTime expiresAt;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL)
    private List<Submission> submissions;

    @PrePersist
    protected void onCreate() {
        startedAt = LocalDateTime.now();
        status = SessionStatus.ACTIVE;
    }
}
