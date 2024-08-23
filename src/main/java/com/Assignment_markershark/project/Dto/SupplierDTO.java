package com.Assignment_markershark.project.Dto;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDTO {

        // lombok for reducing the boiler plate code
    // for uniquelty identify the supplier
    @NotNull(message = "Supplier ID cannot be null")
    private Long supplierId;

    @NotEmpty(message = "Company name cannot be empty")
    @Size(max = 100, message = "Company name cannot exceed 100 characters")
    private String companyName;

    @NotEmpty(message = "Website cannot be empty")
    private String website;

    @NotEmpty(message = "Location cannot be empty")
    private String location;

    @NotEmpty(message = "Nature of business cannot be empty")
    private String natureOfBusiness;

    @NotEmpty(message = "At least one manufacturing process must be specified")
    private List<String> manufacturingProcesses;

    public SupplierDTO(Long supplierId, String companyName, String website, String location, String name, String join) {
        this.supplierId = supplierId;
        this.companyName = companyName;
        this.website = website;
        this.location = location;
        this.natureOfBusiness = name;
        this.manufacturingProcesses = List.of(join);
    }
}
