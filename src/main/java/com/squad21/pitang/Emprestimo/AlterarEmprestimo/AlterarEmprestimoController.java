package com.squad21.pitang.Emprestimo.AlterarEmprestimo;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emprestimos")
public class AlterarEmprestimoController {

    @Autowired
    private AlterarEmprestimoService alterarEmprestimoService;

    @PatchMapping("/{id}/status")
    public ResponseEntity<?> updateStatuss(@PathVariable UUID id, @RequestBody EmprestimoStatusDTO dto) {
        return alterarEmprestimoService.updateStatus(id, dto);
    }
}
