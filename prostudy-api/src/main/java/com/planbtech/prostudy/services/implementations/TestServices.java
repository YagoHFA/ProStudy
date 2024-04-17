package com.planbtech.prostudy.services.implementations;

import com.planbtech.prostudy.repositories.TestRepository;
import com.planbtech.prostudy.services.interfaces.ITesteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServices implements ITesteServices {

    @Autowired
    private TestRepository testRepository;
}
