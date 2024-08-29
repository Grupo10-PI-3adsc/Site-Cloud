package com.example.profissaoPratica;
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

    public ClienteEntity save(CleinteDTO cleinteDTO) {

        ClienteEntity profissao = new ClienteEntity();

//        profissao.setId(profissaoDTO.getId());
        profissao.setNome(cleinteDTO.getNome());
        profissao.setCpfCnpj(cleinteDTO.getCpfCnpj());
        profissao.setEmail(cleinteDTO.getEmail());
        profissao.setEndereco(cleinteDTO.getEndereco());
        profissao.setTelefone(cleinteDTO.getTelefone());
        profissao.setDataCadastro(cleinteDTO.getDataCadastro());

        return clienteRepository.save(profissao);
    }

//    ProfissaoEntity findById(Integer id);
//    List<ProfissaoEntity> findAll();
//    ProfissaoEntity create(ProfissaoDTO obj);
//    ProfissaoEntity update(ProfissaoDTO obj);
//    ProfissaoEntity delete(Integer id);


}
