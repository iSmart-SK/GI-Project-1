package com.CRUD_api.demo.controller;


import com.CRUD_api.demo.model.SeedDonor;
import com.CRUD_api.demo.repository.SeedDonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donors")
public class SeedDonorController {

    @Autowired
    private SeedDonorRepository seedDonorRepository;

    @GetMapping
    public List<SeedDonor> getAllSeedDonors() {
        return seedDonorRepository.findAll();
    }

    @PostMapping
    public SeedDonor createSeedDonor(@RequestBody SeedDonor seedDonor) {
        return seedDonorRepository.save(seedDonor);
    }

    @GetMapping("/{id}")
    public SeedDonor getSeedDonorById(@PathVariable Long id) {
        return seedDonorRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public SeedDonor updateSeedDonor(@PathVariable Long id, @RequestBody SeedDonor updatedSeedDonor) {
        return seedDonorRepository.findById(id).map(seedDonor -> {
            seedDonor.setName(updatedSeedDonor.getName());
            seedDonor.setContactNumber(updatedSeedDonor.getContactNumber());
            seedDonor.setAddress(updatedSeedDonor.getAddress());
            seedDonor.setEmail(updatedSeedDonor.getEmail());
            return seedDonorRepository.save(seedDonor);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteSeedDonor(@PathVariable Long id) {
        seedDonorRepository.deleteById(id);
    }
}

