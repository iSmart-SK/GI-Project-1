package com.CRUD_api.demo.controller;

import com.CRUD_api.demo.model.Seed;
import com.CRUD_api.demo.repository.SeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/seeds")
@CrossOrigin(origins = "*")
public class SeedController {

    @Autowired
    private SeedRepository seedRepository;

     @GetMapping
    public List<Seed> getAllSeeds() {
        return seedRepository.findAll();
    }

    @PostMapping
    public Seed addSeed(@RequestBody Seed seed) {
        return seedRepository.save(seed);
    }

    @GetMapping("/{id}")
    public Seed getSeedById(@PathVariable Long id) {
        return seedRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Seed updateSeed(@PathVariable Long id, @RequestBody Seed seed) {
        Seed existing = seedRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setSeedType(seed.getSeedType());
            existing.setQuantity(seed.getQuantity());
            existing.setDropLocation(seed.getDropLocation());
            existing.setDonorName(seed.getDonorName());
            return seedRepository.save(existing);
        }
        return null;
    }

    @PatchMapping("/{id}")
    public Seed patchSeed(@PathVariable Long id, @RequestBody Seed seed) {
        Optional<Seed> optionalSeed = seedRepository.findById(id);
        if (optionalSeed.isPresent()) {
            Seed existing = optionalSeed.get();
            if (seed.getSeedType() != null) existing.setSeedType(seed.getSeedType());
            if (seed.getQuantity() > 0) existing.setQuantity(seed.getQuantity());
            if (seed.getDropLocation() != null) existing.setDropLocation(seed.getDropLocation());
            if (seed.getDonorName() != null) existing.setDonorName(seed.getDonorName());
            return seedRepository.save(existing);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteSeed(@PathVariable Long id) {
        seedRepository.deleteById(id);
    }

    @GetMapping("/location/{location}")
    public List<Seed> getByLocation(@PathVariable String location) {
        return seedRepository.findByDropLocation(location);
    }

    @GetMapping("/type/{type}")
    public List<Seed> getByType(@PathVariable String type) {
        return seedRepository.findBySeedType(type);
    }
}
