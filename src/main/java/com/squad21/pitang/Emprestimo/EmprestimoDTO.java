package com.squad21.pitang.Emprestimo;
import jakarta.validation.constraints.*;
public record EmprestimoDTO(
        @NotNull(message = "Insira o valor")
        Float valor,

        @NotEmpty(message = "Digite o motivo.")
        String motivo
){   
}
