package com.example.ProjectTest.repository;

import com.example.ProjectTest.dto.DeveloperDTO;
import com.example.ProjectTest.model.Developer;

public interface DeveloperRepository {


    DeveloperDTO getDeveloper(Long id);

    DeveloperDTO save(DeveloperDTO developer);

    DeveloperDTO update(Long id,DeveloperDTO developer);
}
