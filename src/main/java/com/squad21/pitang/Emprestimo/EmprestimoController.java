package com.squad21.pitang.Emprestimo;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/emprestimo/{id}")
public class EmprestimoController {
    @Autowired
    private EmprestimoService emprestimoService;
    @PostMapping("")
        public ResponseEntity<?> createEmprestimo(HttpServletRequest request, HttpServletResponse response, 
        @PathVariable UUID id, @Valid @RequestBody EmprestimoDTO data){
            return emprestimoService.createEmprestimo(request, response, id, data);
    }

}