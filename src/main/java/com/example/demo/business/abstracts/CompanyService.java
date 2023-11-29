package com.example.demo.business.abstracts;

import com.example.demo.business.dtos.requests.CreateCompanyRequest;
import com.example.demo.business.dtos.responses.GetAllCompaniesResponse;
import com.example.demo.business.dtos.responses.GetAllEmployeeResponse;
import com.example.demo.entities.concretes.Company;

import java.util.List;

public interface CompanyService {
    List<GetAllCompaniesResponse> getAll();
    void add(CreateCompanyRequest createCompaniesRequest) throws Exception;
    void delete(Long id) throws Exception;

    void update(GetAllCompaniesResponse getCompaniesResponse) throws Exception;

    GetAllCompaniesResponse findByName(String name);
}
