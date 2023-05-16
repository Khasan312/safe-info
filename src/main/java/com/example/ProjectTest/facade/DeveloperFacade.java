package com.example.ProjectTest.facade;

import com.example.ProjectTest.dto.DeveloperDTO;
import com.example.ProjectTest.service.DeveloperService;
import org.springframework.stereotype.Repository;

@Repository
public class DeveloperFacade {

    private DeveloperService developerService;

    public DeveloperFacade(DeveloperService developerService) {
        this.developerService = developerService;
    }

    public DeveloperDTO getDeveloperById(Long id) {
        return developerService.getDeveloper(id);
    }
    public DeveloperDTO save(DeveloperDTO developerDTO) {
        return developerService.save(developerDTO);
    }

    public DeveloperDTO update(Long id, DeveloperDTO developerDTO) {
        return developerService.update(id,developerDTO);
    }

    public void delete(Long id) {
        developerService.delete(id);
    }
}
