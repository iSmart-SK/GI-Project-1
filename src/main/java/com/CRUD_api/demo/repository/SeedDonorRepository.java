package com.CRUD_api.demo.repository;


import com.CRUD_api.demo.model.SeedDonor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeedDonorRepository extends JpaRepository<SeedDonor, Long> {
}

