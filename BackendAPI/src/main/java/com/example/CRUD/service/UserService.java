package com.example.CRUD.service;
import com.example.CRUD.entity.EnderecoEntity;
import com.example.CRUD.entity.FuncionarioEntity;
import com.example.CRUD.repository.FuncionarioRepository;
import com.example.CRUD.repository.EnderecoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    public FuncionarioEntity save(FuncionarioEntity cliente) {
        if(funcionarioRepository.existsById(cliente.getId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Cliente já cadastrado!");
        }
        cliente.setId(null);
        System.out.println(cliente);
        return funcionarioRepository.save(cliente);
    }

    public List<FuncionarioEntity> listarCliente() {
        return funcionarioRepository.findAll();
    }

    public FuncionarioEntity clientePorId(int id) {
        Optional<FuncionarioEntity> clienteEntityOptional = funcionarioRepository.findById(id);

        if(clienteEntityOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return clienteEntityOptional.get();
    }


    public List<FuncionarioEntity> clientePorNome(String nome) {
        return funcionarioRepository.findByNomeContainingIgnoreCase(nome);
    }

    public FuncionarioEntity atualizarCliente(FuncionarioEntity cliente, int id) {
        if (!funcionarioRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Cliente não encontrado");
        }
        return funcionarioRepository.save(cliente);
    }


    public FuncionarioEntity inativarCliente(int id) {
        Boolean ativo = false;
        Optional<FuncionarioEntity> cliente = funcionarioRepository.findById(id);
        Optional<EnderecoEntity> endereco = enderecoRepository.findByFkCliente(id);

        if (cliente.isPresent()) {
            endereco.ifPresent(enderecoEntity -> enderecoEntity.setIsActive(ativo));
            cliente.get().setIsActive(ativo);
            funcionarioRepository.save(cliente.get());
            endereco.get().setIsActive(ativo);
            return cliente.get();
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Cliente não encontrado ou Endereço");

    }

}
