package com.example.ProjectTest.controller;

import com.example.ProjectTest.dto.DeveloperDTO;
import com.example.ProjectTest.facade.DeveloperFacade;
import com.example.ProjectTest.service.DeveloperService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/developer")
public class DeveloperController {
    private DeveloperFacade developerFacade;

    public DeveloperController(DeveloperFacade developerFacade) {
        this.developerFacade = developerFacade;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeveloperDTO> getDeveloperById(@PathVariable Long id) {
        return new ResponseEntity<>(developerFacade.getDeveloperById(id), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<DeveloperDTO> save(@RequestBody DeveloperDTO developerDTO) {
        return new ResponseEntity<>(developerFacade.save(developerDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DeveloperDTO> update(@PathVariable Long id, @RequestBody DeveloperDTO developerDTO) {
        return new ResponseEntity<>(developerFacade.update(id, developerDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete (@PathVariable Long id) {
        developerFacade.delete(id);
        return new ResponseEntity<>("Developer with ID : " + id + " deleted", HttpStatus.OK);
    }
}
