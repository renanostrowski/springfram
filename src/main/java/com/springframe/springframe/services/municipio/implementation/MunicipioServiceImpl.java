package com.springframe.springframe.services.municipio.implementation;

import com.springframe.springframe.model.dto.MunicipioDTO;
import com.springframe.springframe.model.entity.Municipio;
import com.springframe.springframe.model.entity.UnidadeFederativa;
import com.springframe.springframe.model.form.MunicipioForm;
import com.springframe.springframe.repsository.iMunicipioRepository;
import com.springframe.springframe.repsository.iUnidadeFederativaRepository;
import com.springframe.springframe.services.municipio.interfaces.iMunicipioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MunicipioServiceImpl implements iMunicipioService {

    private iUnidadeFederativaRepository unidadeFederativaRepository;
    private iMunicipioRepository municipioRepository;

    public MunicipioServiceImpl(iMunicipioRepository municipioRepository, iUnidadeFederativaRepository unidadeFederativaRepository){
        this.municipioRepository = municipioRepository;
        this.unidadeFederativaRepository = unidadeFederativaRepository;
    }

    public Municipio findByCodigoIBGE(long codigo){
        return municipioRepository.findByCodigoIBGE(codigo);
    }

    public List<MunicipioDTO> listarMunicipios(){
        List<Municipio> municipios = municipioRepository.findAll();
        return municipios.stream().map(MunicipioDTO::new).collect(Collectors.toList());
    }

    public MunicipioDTO salvarMunicipio(MunicipioForm municipioForm){
        Optional<UnidadeFederativa> uf = unidadeFederativaRepository.findById(municipioForm.getCodigoUF());
        Municipio municipio = municipioForm.convert();
        municipio.setUnidadeFederativa(uf.get());
        municipio = municipioRepository.save(municipio);

        return new MunicipioDTO(municipio);
    }
}
