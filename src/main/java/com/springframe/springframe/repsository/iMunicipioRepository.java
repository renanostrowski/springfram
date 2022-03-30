package com.springframe.springframe.repsository;

import com.springframe.springframe.model.dto.MunicipioDTO;
import com.springframe.springframe.model.entity.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface iMunicipioRepository extends JpaRepository<Municipio, Long> {
    @Query("select m from Municipio m where m.codigoIBGE = :codigo")
    Municipio findByCodigoIBGE(long codigo);
}
