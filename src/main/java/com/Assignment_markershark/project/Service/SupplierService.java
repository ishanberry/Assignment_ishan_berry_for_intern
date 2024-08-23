package com.Assignment_markershark.project.Service;





import com.Assignment_markershark.project.Dto.SupplierDTO;

import com.Assignment_markershark.project.Models.Supplier;
import com.Assignment_markershark.project.Repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<SupplierDTO> getSuppliers(String location, String natureOfBusiness, String manufacturingProcess, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Supplier> supplierPage = supplierRepository.findByLocationAndNatureOfBusinessAndManufacturingProcessesContaining(
                location, natureOfBusiness, manufacturingProcess, pageable);

        return supplierPage.stream()
                .map(supplier -> new SupplierDTO(
                        supplier.getSupplierId(),
                        supplier.getCompanyName(),
                        supplier.getWebsite(),
                        supplier.getLocation(),
                        supplier.getNatureOfBusiness().name(),
                        supplier.getManufacturingProcesses().stream()
                                .collect(Collectors.joining(", "))
                ))
                .collect(Collectors.toList());
    }
}