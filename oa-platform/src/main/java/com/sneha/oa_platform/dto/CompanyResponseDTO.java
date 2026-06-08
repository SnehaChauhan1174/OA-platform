package com.sneha.oa_platform.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyResponseDTO {
    private UUID id;
    private String name;
    private String description;
    private Integer totalTimeMins;
    private Integer codingCount;
    private Integer mcqCount;
    private Integer sqlCount;
    private Integer aptitudeCount;
}

/*
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyResponse{
    private count
}
 */
