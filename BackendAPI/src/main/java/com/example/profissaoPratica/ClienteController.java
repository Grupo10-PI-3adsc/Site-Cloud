package com.example.profissaoPratica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profissoes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteService clienteService;


    @GetMapping
    public List<ClienteEntity> listar() {
        return clienteRepository.findAll();
    }
    @GetMapping("/{id}")
    public ClienteEntity buscarPorIndice (@PathVariable int id) {
        Optional<ClienteEntity> profissaoOpt = clienteRepository.findById(id);
        return clienteRepository.findById(id).orElse(null);
    }
    
    @PostMapping
    public ClienteEntity criar(@RequestBody CleinteDTO cleinteDTO){

        ClienteEntity clienteEntity = clienteService.save(cleinteDTO);
        return clienteRepository.save(clienteEntity);
    }
//    @PostMapping()
//    public ProfissaoEntity criar(@RequestBody ProfissaoEntity profissao)
//    {
//        return profissaoRepository.save(profissao);
//    }

    @PutMapping("/{id}")
    public ClienteEntity atualizar(@PathVariable Integer id, @RequestBody ClienteEntity clienteEntity){
        if(clienteRepository.existsById(id)) {
            clienteEntity.setId(id);
            return clienteRepository.save(clienteEntity);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public String deletarMusica(@PathVariable Integer id) {
        if(clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return "Deletado com sucesso";
        }
        return "Não encontrado";
    }



}
