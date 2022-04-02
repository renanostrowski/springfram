package com.springframe.springframe.reposository;

import com.springframe.springframe.model.entity.AuxilioEmergencial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface iAuxilioEmergencialRepository extends JpaRepository<AuxilioEmergencial, Long> {
    @Query("select a from AuxilioEmergencial a where a.municipio.codigoIBGE = :codigo")
    List<AuxilioEmergencial> listarAuxiliosPorCodigo(Long codigo);
}
