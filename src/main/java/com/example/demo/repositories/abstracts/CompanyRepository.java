package com.example.demo.repositories.abstracts;

import com.example.demo.entities.concretes.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CompanyRepository extends JpaRepository<Company,Long> {
    @Query("SELECT p from Company as p where p.companyName=:name")
    Company customFindByName(String name);
}
