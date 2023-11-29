package com.example.demo.business.dtos.responses;

import com.example.demo.entities.concretes.Company;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class GetAllEmployeeResponse {

    private Long id;
    private String name;
    private String surname;
    private int age;
    private Long company_id;
}
