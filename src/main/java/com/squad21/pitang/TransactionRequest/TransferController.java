package com.squad21.pitang.TransactionRequest;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transferencias")
public class TransferController {
    @Autowired
    private TransferService transferService;

    public record TransferRequest(
        Long numeroContaOrigem,
        Long numeroContaDestino,
        BigDecimal valor
    ) {}

    @PostMapping
    public ResponseEntity<?> transferir(@RequestBody TransferRequest request) {
        try {
            transferService.transferByNumeroConta(request.numeroContaOrigem(), request.numeroContaDestino(), request.valor());
            return ResponseEntity.ok("Transferência realizada com sucesso.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("{\"erro\": \"" + e.getMessage() + "\"}");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"erro\": \"Erro interno: " + e.getMessage() + "\"}");
        }
    }
}
