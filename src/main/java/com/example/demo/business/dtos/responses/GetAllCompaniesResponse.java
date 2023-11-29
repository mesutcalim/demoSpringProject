package com.example.demo.business.dtos.responses;

import com.example.demo.entities.concretes.Employee;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class GetAllCompaniesResponse {

    private Long id;
    private String companyName;
    private List<Employee> employees;
}
