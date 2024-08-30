package com.example.CRUD.service;
import com.example.CRUD.dto.ClienteDTO;
import com.example.CRUD.entity.ClienteEntity;
import com.example.CRUD.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

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


}
