package com.springframe.springframe.services.municipio.interfaces;

import com.springframe.springframe.model.dto.MunicipioDTO;
import com.springframe.springframe.model.entity.Municipio;
import com.springframe.springframe.model.form.MunicipioForm;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

public interface iMunicipioService {
    @Query("select m from Municipio m where m.codigoIBGE = :codigo")
    Municipio findByCodigoIBGE(long codigo);
    MunicipioDTO salvarMunicipio(MunicipioForm municipioForm);
    List<MunicipioDTO> listarMunicipios();
}
