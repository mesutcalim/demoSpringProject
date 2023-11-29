package com.example.demo.business.abstracts;

import com.example.demo.business.dtos.requests.CreateEmployeeRequest;
import com.example.demo.business.dtos.requests.UpdateEmployeeRequest;
import com.example.demo.business.dtos.responses.GetAllEmployeeResponse;

import java.util.List;

public interface EmployeeService {
    void add(CreateEmployeeRequest createEmployeeRequest);
    void update(UpdateEmployeeRequest updateEmployeeRequest) throws Exception;
    void delete(Long id) throws Exception;
    List<GetAllEmployeeResponse> getAll();
    GetAllEmployeeResponse getById(Long id);
}
