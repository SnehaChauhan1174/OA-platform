package com.sneha.oa_platform.Service;

import com.sneha.oa_platform.dto.CompanyRequestDTO;
import com.sneha.oa_platform.mapper.CompanyMapper;
import com.sneha.oa_platform.repository.CompanyRepo;
import com.sneha.oa_platform.entity.Company;
import com.sneha.oa_platform.dto.CompanyResponseDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CompanyService {

    private final CompanyMapper companyMapper;
    private final CompanyRepo companyRepo;

    public CompanyService(CompanyMapper companyMapper, CompanyRepo companyRepo) {// it's a constructor injection
        this.companyMapper = companyMapper;
        this.companyRepo = companyRepo;
    }

    public CompanyResponseDTO addCompany(CompanyRequestDTO companyRequestDTO){

        Company company = companyMapper.toEntity(companyRequestDTO);

        //save to db
        Company savedCompany = companyRepo.save(company);

        //back from model to responseDTO with uuid
        return companyMapper.toResponseDTO(savedCompany);

    }

    public List<CompanyResponseDTO> getAllCompanies(){
        List<CompanyResponseDTO> companyResponseDTOList = new ArrayList<>();
        for(int i=0; i<companyRepo.findAll().size(); i++){
            Company company = companyRepo.findAll().get(i);
            CompanyResponseDTO companyResponseDTO = companyMapper.toResponseDTO(company);
            companyResponseDTOList.add(companyResponseDTO);
        }
        return companyResponseDTOList;
    }

    public CompanyResponseDTO getCompany(@PathVariable UUID id){
        if(companyRepo.findById(id).isPresent()){
            Company company = companyRepo.findById(id).get();
            CompanyResponseDTO companyResponseDTO = companyMapper.toResponseDTO(company);
            return companyResponseDTO;
        }
        else{
            return null;
        }

    }

    public CompanyResponseDTO updateCompany(@Valid @RequestBody CompanyRequestDTO companyReq, @PathVariable UUID id){
        if(companyRepo.findById(id).isPresent()){
            Company company = companyRepo.findById(id).get();
            company.setName(companyReq.getName());
            company.setTotalTimeMins(companyReq.getTotalTimeMins());
            company.setSqlCount(companyReq.getSqlCount());
            company.setCodingCount(companyReq.getCodingCount());
            company.setAptitudeCount(companyReq.getAptitudeCount());
            company.setDescription(companyReq.getDescription());
            companyRepo.save(company);
            CompanyResponseDTO companyResponseDTO = companyMapper.toResponseDTO(company);

            return companyResponseDTO;
        }
        else{
            return null;
        }
    }

    public CompanyResponseDTO deleteCompany(@PathVariable UUID id){
        if(companyRepo.findById(id).isPresent()){
            Company company = companyRepo.findById(id).get();
            companyRepo.delete(company);
            return companyMapper.toResponseDTO(company);
        }
        else{
            return null;
        }
    }
}
