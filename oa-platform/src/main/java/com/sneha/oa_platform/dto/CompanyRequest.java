package com.sneha.oa_platform.dto;

import lombok.Data;

@Data
public class CompanyRequest {
    private String name;
    private String description;
    private Integer totalTimeMins;
    private Integer codingCount;
    private Integer mcqCount;
    private Integer sqlCount;
    private Integer aptitudeCount;

}
