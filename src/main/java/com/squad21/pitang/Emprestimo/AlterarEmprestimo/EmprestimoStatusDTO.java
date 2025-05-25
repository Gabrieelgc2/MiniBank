package com.squad21.pitang.Emprestimo.AlterarEmprestimo;

import jakarta.validation.constraints.NotEmpty;

public record EmprestimoStatusDTO(
    @NotEmpty(message = "Insira o status que você quer alterar")
    String status
){    
}