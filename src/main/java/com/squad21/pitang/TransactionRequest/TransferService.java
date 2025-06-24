package com.squad21.pitang.TransactionRequest;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.squad21.pitang.User.Client.ClientModel.ClientModel;

import jakarta.persistence.EntityManager; /* O EntityManager é a principal interface para interagir com o banco de dados, 
                                          permitindo criar, ler, atualizar e deletar entidades. */
import jakarta.persistence.PersistenceContext; /* 
                                                                                                 */
import jakarta.transaction.Transactional;

@Service
public class TransferService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void transferByNumeroConta(Long numeroContaOrigem, Long numeroContaDestino, BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor da transferência deve ser maior que zero.");
        }

        // Buscar cliente de origem e destino
        ClientModel origem = em.createQuery("SELECT c FROM Client c WHERE c.numeroConta = :num", ClientModel.class)
                               .setParameter("num", numeroContaOrigem)
                               .getSingleResult();

        ClientModel destino = em.createQuery("SELECT c FROM Client c WHERE c.numeroConta = :num", ClientModel.class)
                                .setParameter("num", numeroContaDestino)
                                .getSingleResult();

        // Validar saldo
        if (origem.getSaldo().compareTo(valor) < 0) {
            throw new IllegalArgumentException("Saldo insuficiente na conta de origem.");
        }

        // Atualizar saldos
        origem.setSaldo(origem.getSaldo().subtract(valor));
        destino.setSaldo(destino.getSaldo().add(valor));

        // Persistir alterações
        em.merge(origem);
        em.merge(destino);
    }
}
