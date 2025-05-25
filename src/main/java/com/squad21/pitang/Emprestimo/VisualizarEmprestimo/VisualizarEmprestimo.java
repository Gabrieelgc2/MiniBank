package com.squad21.pitang.Emprestimo.VisualizarEmprestimo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.squad21.pitang.Emprestimo.EmprestimoService;

@RestController
@RequestMapping("")
public class VisualizarEmprestimo {
    @Autowired
    EmprestimoService emprestimoService;
    @GetMapping("/verEmprestimo")
    public ResponseEntity<?> verEmprestimo(){
        return ResponseEntity.status(200).body(emprestimoService.getAllUsers());
    }
    }
