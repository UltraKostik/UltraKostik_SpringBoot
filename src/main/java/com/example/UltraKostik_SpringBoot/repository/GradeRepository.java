package com.example.UltraKostik_SpringBoot.repository;

import com.example.UltraKostik_SpringBoot.model.Grade;
import com.example.UltraKostik_SpringBoot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {

    List<Grade> findByUser(User user);

    List<Grade> findByUserAndSubject(User user, String subject);

}
