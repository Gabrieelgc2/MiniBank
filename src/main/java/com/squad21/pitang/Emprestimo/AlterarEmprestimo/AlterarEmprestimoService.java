package com.squad21.pitang.Emprestimo.AlterarEmprestimo;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.squad21.pitang.Emprestimo.EmprestimoModel;
import com.squad21.pitang.Emprestimo.EmprestimoRepository;

@Service
public class AlterarEmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    public ResponseEntity<?> updateStatus(UUID id, EmprestimoStatusDTO dto) {
        var emprestimoOptional = emprestimoRepository.findById(id);
        
        if (emprestimoOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empréstimo não encontrado");
        }
        
        var emprestimo = emprestimoOptional.get();
        emprestimo.setStatus(dto.status());
        /*
        Basicamente após eu encontrar o id do Empréstimo,
        E se for "APROVADO", eu devo pegar o valor do empréstimo e atualizar no saldo.

        Como pegar o valor do empréstimo?
        */
        if(dto.status() == "APROVADO"){
            
        }

        var updated = emprestimoRepository.save(emprestimo);
        return ResponseEntity.ok(updated);
    }
}
