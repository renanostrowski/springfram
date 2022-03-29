package com.springframe.springframe.services.usuario.implementation;

import com.springframe.springframe.model.dto.MunicipioDTO;
import com.springframe.springframe.model.dto.UsuarioDTO;
import com.springframe.springframe.model.entity.Municipio;
import com.springframe.springframe.repsository.iMunicipioRepository;
import com.springframe.springframe.services.usuario.interfaces.iMunicipioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MunicipioServiceImpl implements iMunicipioService {

    private iMunicipioRepository municipioRepository;

    public MunicipioServiceImpl(iMunicipioRepository municipioRepository){
        this.municipioRepository = municipioRepository;
    }

    public List<MunicipioDTO> listarMunicipios(){
        List<Municipio> municipios = municipioRepository.findAll();
        return municipios.stream().map(MunicipioDTO::new).collect(Collectors.toList());
    }
}
