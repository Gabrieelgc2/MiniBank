package com.squad21.pitang.Emprestimo;
import java.util.UUID;

import com.squad21.pitang.User.Client.ClientModel.ClientModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Data
@Entity(name = "EmprestimoClient")
public class EmprestimoModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    private ClientModel cliente;

    private float valor;
    private String motivo;
    private String status;

    public EmprestimoModel(ClientModel cliente) {
        this.cliente = cliente;
    }

    public EmprestimoModel() {
    }

    public void setValores(float valor, String motivo, String status){
        this.valor = valor;
        this.motivo = motivo;
        this.status = status;
    }
}