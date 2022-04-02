package com.springframe.springframe.services.auxilioEmergencial.implementation;

import com.springframe.springframe.model.dto.AuxilioEmergencialDTO;
import com.springframe.springframe.model.entity.AuxilioEmergencial;
import com.springframe.springframe.reposository.iAuxilioEmergencialRepository;
import com.springframe.springframe.services.auxilioEmergencial.interfaces.iAuxlioEmergencialService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuxilioEmergencialServiceImpl implements iAuxlioEmergencialService {

    iAuxilioEmergencialRepository auxilioEmergencialRepository;

    public AuxilioEmergencialServiceImpl(iAuxilioEmergencialRepository auxilioEmergencialRepository){
        this.auxilioEmergencialRepository = auxilioEmergencialRepository;
    }

    public List<AuxilioEmergencialDTO> listarAuxilios(){
        List<AuxilioEmergencial> list = auxilioEmergencialRepository.findAll();
        return list.stream().map(AuxilioEmergencialDTO::new).collect(Collectors.toList());
    }
}
