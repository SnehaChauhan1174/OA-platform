package com.sneha.oa_platform.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.sneha.oa_platform.Service.CompanyService;
import com.sneha.oa_platform.dto.CompanyRequestDTO;
import com.sneha.oa_platform.dto.CompanyResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin/companies")
@RequiredArgsConstructor
public class AdminCompanyController {
    private final CompanyService companyService;
    @PostMapping("/add")
    public ResponseEntity<CompanyResponseDTO> addCompany(@Valid @RequestBody CompanyRequestDTO companyReq) {
        CompanyResponseDTO responseDTO = companyService.addCompany(companyReq);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/")
    public ResponseEntity<List<CompanyResponseDTO>> getAllCompanies(){
        List<CompanyResponseDTO> companyResponseDTOList = companyService.getAllCompanies();
        return ResponseEntity.ok(companyResponseDTOList);

    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyResponseDTO> getCompany(@PathVariable UUID id){
        CompanyResponseDTO responseDTO = companyService.getCompany(id);
        if(responseDTO == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/")
    public ResponseEntity<CompanyResponseDTO> updateCompany(@Valid @RequestBody CompanyRequestDTO companyReq, @PathVariable UUID id){
        CompanyResponseDTO responseDTO = companyService.updateCompany(companyReq, id);
        if(responseDTO == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(responseDTO);

    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable UUID id){

        companyService.deleteCompany(id);
    }



}
