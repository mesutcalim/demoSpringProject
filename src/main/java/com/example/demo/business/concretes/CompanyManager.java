package com.example.demo.business.concretes;

import com.example.demo.business.abstracts.CompanyService;
import com.example.demo.business.dtos.requests.CreateCompanyRequest;
import com.example.demo.business.dtos.responses.GetAllCompaniesResponse;
import com.example.demo.business.dtos.responses.GetAllEmployeeResponse;
import com.example.demo.entities.concretes.Company;
import com.example.demo.entities.concretes.Employee;
import com.example.demo.repositories.abstracts.CompanyRepository;
import com.example.demo.repositories.abstracts.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
public class CompanyManager implements CompanyService {

    private CompanyRepository companyRepository;
    private EmployeeRepository employeeRepository;
    @Override
    public List<GetAllCompaniesResponse> getAll() {

        List<Company> Company = companyRepository.findAll();
        List<Employee> employees = employeeRepository.findAll();
        List<GetAllCompaniesResponse> getCompanyResponses = new ArrayList<>();
        //List<GetEmployeeResponse> employeeResponses = new ArrayList<>();

        for (Company company : Company) {
            List<GetAllEmployeeResponse> employeeResponses = new ArrayList<>();
            GetAllCompaniesResponse addItem = GetAllCompaniesResponse.builder()
                    .id(company.getId())
                    .companyName(company.getCompanyName())
                    .employees(company.getEmployees())
                    .build();

            getCompanyResponses.add(addItem);
            for (Employee employee : employees) {
                if (addItem.getId() == employee.getCompany().getId()) {
                    GetAllEmployeeResponse addItem1 = new GetAllEmployeeResponse();
                    addItem1.setId(employee.getId());
                    addItem1.setName(employee.getName());
                    addItem1.setSurname(employee.getSurname());
                    addItem1.setAge(employee.getAge());
                    addItem1.setCompany_id(employee.getCompany().getId());

                    employeeResponses.add(addItem1);
                }
            }
        }

        return getCompanyResponses;
    }

    @Override
    public void add(CreateCompanyRequest createCompaniesRequest) throws Exception {
        Company company1 = new Company();

        for (Company company : companyRepository.findAll()) {
            if (createCompaniesRequest.getCompanyName().equals(company.getCompanyName())) {
                throw new Exception("Girilen Şirket Kayıtlarımızda Mevcut");
            }
        }
//        if (createCompaniesRequest.getCompanyName().isEmpty()) {
//            throw new Exception("Şirket Adı Alanı Boş Olamaz!!!");
//        }

        company1.setCompanyName(createCompaniesRequest.getCompanyName());

        companyRepository.save(company1);

    }

    @Override
    public void delete(Long id) throws Exception {
        companyRepository.delete(companyRepository.getReferenceById(id));
    }

    @Override
    public void update(GetAllCompaniesResponse getCompaniesResponse) throws Exception {
        Company company = companyRepository.getReferenceById(getCompaniesResponse.getId());
        company.setCompanyName(getCompaniesResponse.getCompanyName());

        companyRepository.save(company);
    }

    @Override
    public GetAllCompaniesResponse findByName(String name) {
       Company company=companyRepository.customFindByName(name);
       GetAllCompaniesResponse response = GetAllCompaniesResponse.builder()
                .id(company.getId())
                .companyName(company.getCompanyName())
                .employees(company.getEmployees())
                .build();

        return response;
    }
}
