package com.Assignment_markershark.project.Repository;


import com.Assignment_markershark.project.Models.NatureOfBusiness;
import com.Assignment_markershark.project.Models.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {


    Page<Supplier> findByLocationAndNatureOfBusinessAndManufacturingProcessesContaining(
            String location, String natureOfBusiness, String manufacturingProcess, Pageable pageable);
}
