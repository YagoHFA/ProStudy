package com.planbtech.prostudy.services.interfaces;

import com.planbtech.prostudy.DTO.SkillTestMinDTO;
import com.planbtech.prostudy.repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITesteServices {

    List<SkillTestMinDTO> findAll();


}
