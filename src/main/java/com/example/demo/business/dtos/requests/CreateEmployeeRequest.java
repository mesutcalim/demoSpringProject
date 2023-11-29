package com.example.demo.business.dtos.requests;

import com.example.demo.entities.concretes.Company;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateEmployeeRequest {
    @NotNull
    @Size(min = 3)
    private String name;
    @NotNull
    @Size(min = 3)
    private String surname;
    @Min(18)@Max(65)
    private int age;
    private Long company_id;
}
