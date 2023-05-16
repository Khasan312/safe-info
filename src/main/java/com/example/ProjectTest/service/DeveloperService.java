package com.example.ProjectTest.service;

import com.example.ProjectTest.dto.DeveloperDTO;
import com.example.ProjectTest.model.Developer;
import com.example.ProjectTest.repository.DeveloperRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DeveloperService implements DeveloperRepository {

    private JdbcTemplate jdbcTemplate;

    public DeveloperService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }




    @Override
    public DeveloperDTO getDeveloper(Long id) {
        String sqlQuery = "SELECT * FROM developers WHERE id = ?";
        return jdbcTemplate.queryForObject(sqlQuery, new Object[]{id}, (rs, rowNum) -> {
            return new DeveloperDTO(rs.getLong("id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("email"));
        });
    }

    public DeveloperDTO save(DeveloperDTO developer) {
        String sqlQuery = "INSERT INTO developers (first_name, last_name, email) VALUES ( ?, ?, ?)";
        jdbcTemplate.update(sqlQuery, developer.getFirstName(), developer.getLastName(), developer.getEmail());
        return new DeveloperDTO(developer.getId(), developer.getFirstName(), developer.getLastName(), developer.getEmail());
    }

    @Override
    public DeveloperDTO update(Long id,DeveloperDTO developer) {
        String sqlQuery = "UPDATE developers SET first_name = ?, last_name = ?, email = ? WHERE id = ?";
        jdbcTemplate.update(sqlQuery, developer.getFirstName(), developer.getLastName(), developer.getEmail(), id);
        return new DeveloperDTO(developer.getId(),developer.getFirstName(), developer.getLastName(), developer.getEmail());


    }

    public void delete(Long id) {
        String sqlQuery = "DELETE FROM developers WHERE id = ?";
        jdbcTemplate.update(sqlQuery, id);
    }
}





