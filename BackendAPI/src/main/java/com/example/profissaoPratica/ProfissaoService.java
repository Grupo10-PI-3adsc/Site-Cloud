package com.example.profissaoPratica;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.profissaoPratica.ProfissaoDTO;
import com.example.profissaoPratica.ProfissaoEntity;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ProfissaoService {

    @Autowired
    private ProfissaoRepository profissaoRepository;

    public ProfissaoEntity save(ProfissaoDTO profissaoDTO) {

        ProfissaoEntity profissao = new ProfissaoEntity();

//        profissao.setId(profissaoDTO.getId());
        profissao.setNome(profissaoDTO.getNome());
        profissao.setCargaHoraria(profissaoDTO.getCargaHoraria());
        profissao.setSalario(profissaoDTO.getSalario());

        return profissaoRepository.save(profissao);
    }

//    ProfissaoEntity findById(Integer id);
//    List<ProfissaoEntity> findAll();
//    ProfissaoEntity create(ProfissaoDTO obj);
//    ProfissaoEntity update(ProfissaoDTO obj);
//    ProfissaoEntity delete(Integer id);


}
