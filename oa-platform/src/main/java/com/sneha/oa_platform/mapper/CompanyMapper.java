package com.sneha.oa_platform.mapper;

import com.sneha.oa_platform.dto.CompanyRequestDTO;
import com.sneha.oa_platform.dto.CompanyResponseDTO;
import com.sneha.oa_platform.entity.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    Company toEntity(CompanyRequestDTO companyRequestDTO);
    CompanyResponseDTO toResponseDTO(Company company);

}
