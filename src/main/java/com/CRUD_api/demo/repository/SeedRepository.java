package com.CRUD_api.demo.repository;


import com.CRUD_api.demo.model.Seed;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SeedRepository extends JpaRepository<Seed, Long> {
    List<Seed> findByDropLocation(String dropLocation);
    List<Seed> findBySeedType(String seedType);
}
