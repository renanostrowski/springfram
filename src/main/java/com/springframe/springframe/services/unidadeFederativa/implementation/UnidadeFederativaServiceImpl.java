package com.springframe.springframe.services.unidadeFederativa.implementation;

import com.springframe.springframe.model.dto.MunicipioDTO;
import com.springframe.springframe.model.dto.UnidadeFederativaDTO;
import com.springframe.springframe.model.entity.Municipio;
import com.springframe.springframe.model.entity.UnidadeFederativa;
import com.springframe.springframe.model.form.MunicipioForm;
import com.springframe.springframe.repsository.iUnidadeFederativaRepository;
import com.springframe.springframe.services.unidadeFederativa.interfaces.iUnidadeFedetativaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UnidadeFederativaServiceImpl implements iUnidadeFedetativaService {

    private iUnidadeFederativaRepository unidadeFederativaRepository;

    public UnidadeFederativaServiceImpl(iUnidadeFederativaRepository unidadeFederativaRepository){
        this.unidadeFederativaRepository = unidadeFederativaRepository;
    }

    public List<UnidadeFederativaDTO> findAll(){
        List<UnidadeFederativa> ufs = unidadeFederativaRepository.findAll();
        return  ufs.stream().map(UnidadeFederativaDTO::new).collect(Collectors.toList());
    }

    public UnidadeFederativa findById(long id){
        return unidadeFederativaRepository.findById(id);
    }

    public List<UnidadeFederativaDTO> ufCidades(List<MunicipioDTO> municipioForms){
        List<UnidadeFederativaDTO> unidadeFederativaDTOS = new ArrayList<>();
        for(MunicipioDTO municipio : municipioForms){
            Optional<UnidadeFederativa> uf = unidadeFederativaRepository.findById(municipio.getUnidadeFederativaDTO().getCodigoUF());
            unidadeFederativaDTOS.add(new UnidadeFederativaDTO(uf.get()));
        }

        return unidadeFederativaDTOS;
    }
}
