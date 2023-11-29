package com.example.demo.api.controller;

import com.example.demo.business.abstracts.EmployeeService;
import com.example.demo.business.dtos.requests.CreateEmployeeRequest;
import com.example.demo.business.dtos.requests.UpdateEmployeeRequest;
import com.example.demo.business.dtos.responses.GetAllEmployeeResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping("/getall")
    public List<GetAllEmployeeResponse> getAll() {
        return employeeService.getAll();

    }
    @GetMapping("/getbyid")
    public GetAllEmployeeResponse getById(Long id){
        return employeeService.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody  CreateEmployeeRequest createEmployeeRequest) {
        employeeService.add(createEmployeeRequest);

    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateEmployeeRequest updateEmployeeRequest) throws Exception {
        employeeService.update(updateEmployeeRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) throws Exception {
        employeeService.delete(id);
    }
}
