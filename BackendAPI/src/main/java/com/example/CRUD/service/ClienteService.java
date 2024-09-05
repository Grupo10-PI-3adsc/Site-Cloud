package com.example.CRUD.service;
import com.example.CRUD.dto.ClienteDTO;
import com.example.CRUD.dto.EnderecoDTO;
import com.example.CRUD.entity.ClienteEntity;
import com.example.CRUD.entity.EnderecoEntitiy;
import com.example.CRUD.repository.ClienteRepository;
import com.example.CRUD.repository.EnderecoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    public ClienteEntity save(ClienteDTO cleinteDTO) {

        ClienteEntity cliente = new ClienteEntity();

        cliente.setNome(cleinteDTO.getNome());
        cliente.setCpfCnpj(cleinteDTO.getCpfCnpj());
        cliente.setEmail(cleinteDTO.getEmail());
        cliente.setEndereco(cleinteDTO.getEndereco());
        cliente.setTelefone(cleinteDTO.getTelefone());
        cliente.setDataCadastro(cleinteDTO.getDataCadastro());

        return clienteRepository.save(cliente);
    }

    public ResponseEntity<EnderecoEntitiy> save(EnderecoDTO enderecoDTO) {

        EnderecoEntitiy enderecoEntitiy = new EnderecoEntitiy();
        Optional<ClienteEntity> clienteOpt = clienteRepository.findById(enderecoDTO.getFkCliente());

        if (!clienteOpt.isEmpty()){
            enderecoEntitiy.setBairro(enderecoDTO.getBairro());
            enderecoEntitiy.setCep(enderecoDTO.getCep());
            enderecoEntitiy.setComplemento(enderecoDTO.getComplemento());
            enderecoEntitiy.setDdd(enderecoDTO.getDdd());
            enderecoEntitiy.setGia(enderecoDTO.getGia());
            enderecoEntitiy.setIbge(enderecoDTO.getIbge());
            enderecoEntitiy.setLocalidade(enderecoDTO.getLocalidade());
            enderecoEntitiy.setLogradouro(enderecoDTO.getLogradouro());
            enderecoEntitiy.setSiafi(enderecoDTO.getSiafi());
            enderecoEntitiy.setUf(enderecoDTO.getUf());
            enderecoEntitiy.setFkCliente(enderecoDTO.getFkCliente());

            return ResponseEntity.status(201).body(enderecoRepository.save(enderecoEntitiy));
        }

        return ResponseEntity.status(404).build();
    }


}
