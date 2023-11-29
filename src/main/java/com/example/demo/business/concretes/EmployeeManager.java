package com.example.demo.business.concretes;

import com.example.demo.business.abstracts.EmployeeService;
import com.example.demo.business.dtos.requests.CreateEmployeeRequest;
import com.example.demo.business.dtos.requests.UpdateEmployeeRequest;
import com.example.demo.business.dtos.responses.GetAllEmployeeResponse;
import com.example.demo.entities.concretes.Company;
import com.example.demo.entities.concretes.Employee;
import com.example.demo.repositories.abstracts.CompanyRepository;
import com.example.demo.repositories.abstracts.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeManager implements EmployeeService {
    private CompanyRepository companyRepository;
    private EmployeeRepository employeeRepository;

    @Override
    public void add(CreateEmployeeRequest createEmployeeRequest) {

        List<Company> companies = companyRepository.findAll();
        Employee employee= new Employee();

        for (Company company : companies) {
            if(company.getId() == createEmployeeRequest.getCompany_id()) {
                employee.setName(createEmployeeRequest.getName());
                employee.setSurname(createEmployeeRequest.getSurname());
                employee.setAge(createEmployeeRequest.getAge());
                employee.setCompany(company);
                employeeRepository.save(employee);
            }
        }
    }

    @Override
    public void update(UpdateEmployeeRequest updateEmployeeRequest) throws Exception {
        List<Company> companies = companyRepository.findAll();
        Employee employee = new Employee();
        for (Company company: companies) {
            if(company.getId() == updateEmployeeRequest.getCompany_id()) {
                employee.setName(updateEmployeeRequest.getName());
                employee.setSurname(updateEmployeeRequest.getSurname());
                employee.setAge(updateEmployeeRequest.getAge());
                employee.setCompany(company);
                employeeRepository.save(employee);
            }
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<GetAllEmployeeResponse> getAll() {
        List<Employee> employees = employeeRepository.findAll();
        List<GetAllEmployeeResponse> getAllEmployeeResponses = new ArrayList<>();
        for (Employee employee : employees) {
            GetAllEmployeeResponse addItem = new GetAllEmployeeResponse();
            addItem.setId(employee.getId());
            addItem.setName(employee.getName());
            addItem.setSurname(employee.getSurname());
            addItem.setAge(employee.getAge());
            addItem.setCompany_id(employee.getCompany().getId());
            getAllEmployeeResponses.add(addItem);
        }
        return getAllEmployeeResponses;
    }

    @Override
    public GetAllEmployeeResponse getById(Long id) {
        Employee employees = employeeRepository.findById(id).orElseThrow();
        GetAllEmployeeResponse response = new GetAllEmployeeResponse();

        response.setId(employees.getId());
        response.setName(employees.getName());
        response.setSurname(employees.getSurname());
        response.setAge(employees.getAge());
        response.setCompany_id(employees.getCompany().getId());

        return response;
    }
}
