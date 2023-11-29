package com.example.demo.business.dtos.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UpdateEmployeeRequest {

    @NotNull
    @Min(1)
    private Long id;
    @Size(min = 3)
    @NotNull
    private String name;
    @Size(min = 3)
    @NotNull
    private String surname;
    @Min(18)
    private int age;
    @NotNull
    @Min(0)
    private Long company_id;
}
