package com.example.demo.api.controller;

import com.example.demo.business.abstracts.CompanyService;
import com.example.demo.business.dtos.requests.CreateCompanyRequest;
import com.example.demo.business.dtos.responses.GetAllCompaniesResponse;
import com.example.demo.entities.concretes.Company;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/company")
public class CompanyController {
    private CompanyService companyService;

    @GetMapping("/getall")
    public List<GetAllCompaniesResponse> getAll() {
        return companyService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody CreateCompanyRequest createCompanyRequest) throws Exception {
        companyService.add(createCompanyRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) throws Exception {
        companyService.delete(id);
    }
    @PutMapping("/update")
    public void update(@RequestBody GetAllCompaniesResponse getLanguageResponse) throws Exception {
        companyService.update(getLanguageResponse);
    }

    @GetMapping("/get/{name}")
    public GetAllCompaniesResponse getByName(@PathVariable String name) {
       return companyService.findByName(name);

    }

}
