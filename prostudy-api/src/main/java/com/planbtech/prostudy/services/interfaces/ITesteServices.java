package com.planbtech.prostudy.services.interfaces;

import com.planbtech.prostudy.DTO.SkillTestDTO.SkillTestDTO;
import com.planbtech.prostudy.DTO.SkillTestDTO.SkillTestMinDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITesteServices {

    List<SkillTestMinDTO> findAll();


    SkillTestDTO findExam(String projectId);
}
