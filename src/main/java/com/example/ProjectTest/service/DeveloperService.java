package com.example.ProjectTest.service;

import com.example.ProjectTest.dto.DeveloperDTO;
import com.example.ProjectTest.model.Developer;
import com.example.ProjectTest.repository.DeveloperJPARepository;
import com.example.ProjectTest.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeveloperService implements DeveloperRepository {

    @Autowired
    private DeveloperJPARepository developerJPARepository;

    @Override
    public DeveloperDTO getDeveloper(Long id) {
        Optional<Developer> optionalDeveloper = developerJPARepository.findById(id);
            if(optionalDeveloper.isPresent()){
                Developer developer = optionalDeveloper.get();

                //Create and return DeveloperDTO object
                DeveloperDTO developerDTO = new DeveloperDTO(developer.getId(),
                                                developer.getFirstName(),
                                                developer.getLastName(),
                                                developer.getEmail());
                return developerDTO;
            }
            throw new RuntimeException("Developer not found");


    }

    @Override
    public DeveloperDTO save(DeveloperDTO developer) {
        Developer developerEntity = new Developer();
        developerEntity.setFirstName(developer.getFirstName());
        developerEntity.setLastName(developer.getLastName());
        developerEntity.setEmail(developer.getEmail());
        Developer savedDeveloper = developerJPARepository.save(developerEntity);
        DeveloperDTO developerDTO = new DeveloperDTO(savedDeveloper.getId(),
                                                    savedDeveloper.getFirstName(),
                                                    savedDeveloper.getLastName(),
                                                    savedDeveloper.getEmail());
        return developerDTO;
    }

    @Override
    public DeveloperDTO update(Long id, DeveloperDTO developer) {
        Developer developerEntity = new Developer();
        developerEntity.setId(id);
        developerEntity.setFirstName(developer.getFirstName());
        developerEntity.setLastName(developer.getLastName());
        developerEntity.setEmail(developer.getEmail());
        Developer savedDeveloper = developerJPARepository.save(developerEntity);
        DeveloperDTO developerDTO = new DeveloperDTO(savedDeveloper.getId(),
                                                    savedDeveloper.getFirstName(),
                                                    savedDeveloper.getLastName(),
                                                    savedDeveloper.getEmail());
        return developerDTO;
    }

    public void delete(Long id) {
        developerJPARepository.deleteById(id);
    }
}





