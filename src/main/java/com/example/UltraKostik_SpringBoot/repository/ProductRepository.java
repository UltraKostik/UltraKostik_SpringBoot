package com.example.UltraKostik_SpringBoot.repository;

import com.example.UltraKostik_SpringBoot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<User, Long> {
}
