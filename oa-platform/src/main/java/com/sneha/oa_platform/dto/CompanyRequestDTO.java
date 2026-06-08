package com.sneha.oa_platform.dto;

import lombok.Data;

import java.time.LocalDateTime;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Data
public class CompanyRequestDTO {

    @NotBlank(message = "Company name cannot be blank")
    private String name;
    private String description;
    @NotNull(message = "Total time is required")
    @Min(value=1, message = "Total time must be at least 1 min")
    private Integer totalTimeMins;
    @Min(value=0, message = "Coding count cannot be negative")
    private Integer codingCount;
    @Min(value = 0, message = "mcq count cannot be negative")
    private Integer mcqCount;
    @Min(value = 0, message = "SQL count cannot be negative")
    private Integer sqlCount;
    @Min(value = 0, message = "aptitude count cannot be negative")
    private Integer aptitudeCount;

}
