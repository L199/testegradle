package com.br.itau.app.teste.controller;

import com.br.itau.app.teste.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TesteController {


    @Autowired
    private DatabaseService databaseService;

    @GetMapping("/execute-query")
    public List<Map<String, Object>> executeQuery(@RequestParam String query) {
        return databaseService.executeQuery(query);
    }

    @ExceptionHandler(DataAccessException.class)
    public String handleDataAccessException(DataAccessException ex) {
        return "Database error: " + ex.getMessage();
    }
}
