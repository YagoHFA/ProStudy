package com.planbtech.prostudy.services.implementations;

import com.planbtech.prostudy.DTO.SkillTestDTO;
import com.planbtech.prostudy.DTO.SkillTestMinDTO;
import com.planbtech.prostudy.repositories.TestRepository;
import com.planbtech.prostudy.services.interfaces.ITesteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServices implements ITesteServices {

    @Autowired
    private TestRepository testRepository;

    @Override
    public List<SkillTestMinDTO> findAll() {
        return testRepository.findAll().stream().map(SkillTestMinDTO::new).toList();
    }

    @Override
    public SkillTestDTO findExam(String projectId) {
        return testRepository.findById(projectId).map(SkillTestDTO::new).orElseThrow();
    }
}
