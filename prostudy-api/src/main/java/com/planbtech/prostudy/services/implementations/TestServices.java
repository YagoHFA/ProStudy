package com.planbtech.prostudy.services.implementations;

import com.planbtech.prostudy.DTO.SkillTestDTO.SkillTestDTO;
import com.planbtech.prostudy.DTO.SkillTestDTO.SkillTestMinDTO;
import com.planbtech.prostudy.repositories.TestRepository;
import com.planbtech.prostudy.services.interfaces.ITesteServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServices implements ITesteServices {

    @Autowired
    private TestRepository testRepository;

    @Transactional
    @Override
    public List<SkillTestMinDTO> findAll() {
        return testRepository.findAll().stream().map(SkillTestMinDTO::new).toList();
    }

    @Transactional
    @Override
    public SkillTestDTO findExam(String testId) {
        SkillTestDTO dto = testRepository.findById(testId).map(SkillTestDTO::new).orElseThrow();
        return dto;
    }
}
