package com.sneha.oa_platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sneha.oa_platform.entity.Company;
import java.util.UUID;

public interface CompanyRepo extends JpaRepository<Company, UUID> {

}
