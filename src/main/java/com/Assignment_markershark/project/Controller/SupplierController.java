package com.Assignment_markershark.project.Controller;

import com.Assignment_markershark.project.Dto.SupplierDTO;
import com.Assignment_markershark.project.Service.SupplierService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("/query")
    public ResponseEntity<List<SupplierDTO>> querySuppliers(
            @Valid @RequestBody SupplierDTO supplierDTO,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        List<SupplierDTO> suppliers = supplierService.getSuppliers(
                supplierDTO.getLocation(),
                supplierDTO.getNatureOfBusiness(),
                String.join(", ", supplierDTO.getManufacturingProcesses()),
                page,
                size
        );
        return new ResponseEntity<>(suppliers, HttpStatus.OK);
    }
}