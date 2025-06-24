package com.squad21.pitang.Emprestimo;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.squad21.pitang.User.Client.ClientController.ClientRepository.ClientRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Service
public class EmprestimoService{
    @Autowired
    private EmprestimoRepository emprestimoRepository;
    @Autowired
    private ClientRepository clientRepository;
    public ResponseEntity<?> createEmprestimo(HttpServletRequest request, HttpServletResponse response, UUID id, 
    EmprestimoDTO emprestimo){
        var ClientAttributes = clientRepository.findById(id);
        if(ClientAttributes.isEmpty()){ // Se o usuário não existir, não dá permissão para entrar na rota "/emprestimo"
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O usuário não possui permissão!");
        } else{ // Se exisitir, dá permissão para acessar a rota e realizar empréstimo
        var client = ClientAttributes.get();
        EmprestimoModel emprestimoModel = new EmprestimoModel(client);
        emprestimoModel.setValores(emprestimo.valor(), emprestimo.motivo(), "PENDENTE");
        // request.setAttribute("status", emprestimoModel.getStatus());

        var EmprestimoCreated = this.emprestimoRepository.save(emprestimoModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(EmprestimoCreated);
        }
        
    }
        public List<EmprestimoModel> getAllUsers() {
            return emprestimoRepository.findAll();
        }
}
