package com.Assignment_markershark.project.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;




@Entity
@Table(name = "suppliers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierId; // Unique identifier for each supplier

    private String companyName;
    private String website;
    private String location;

    @Enumerated(EnumType.STRING)
    private NatureOfBusiness natureOfBusiness;

    @ElementCollection
    private List<String> manufacturingProcesses; // List of manufacturing processes

    // Getters and Setters
}
