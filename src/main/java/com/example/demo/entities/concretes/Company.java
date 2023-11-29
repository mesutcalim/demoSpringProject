package com.example.demo.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Table(name = "companies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;

    @OneToMany(mappedBy = "company")
    private List<Employee> employees;
}
