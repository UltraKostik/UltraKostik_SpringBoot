package com.example.UltraKostik_SpringBoot.service;


import com.example.UltraKostik_SpringBoot.model.Grade;
import com.example.UltraKostik_SpringBoot.model.User;
import com.example.UltraKostik_SpringBoot.repository.GradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeService {

    private final GradeRepository gradeRepository;

    public List<Grade> getGrades(User user, String subject){
        if (subject == null || subject.isBlank()){
            return gradeRepository.findByUser(user);
        }
        else{
            return gradeRepository.findByUserAndSubject(user, subject);
        }
    }

    public void saveGrade(Grade grade){
        gradeRepository.save(grade);
    }

    public Grade getById(Long id){
        return gradeRepository.findById(id).orElseThrow(()-> new RuntimeException("Оценка не найдена"));
    }

    public void deleteGrade(Long id){
        gradeRepository.deleteById(id);
    }
}
