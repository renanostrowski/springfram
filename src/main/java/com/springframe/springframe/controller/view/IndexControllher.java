package com.springframe.springframe.controller.view;

import com.springframe.springframe.api.interfaces.iApiExterna;
import com.springframe.springframe.model.dto.AuxilioEmergencialDTO;
import com.springframe.springframe.model.dto.MunicipioDTO;
import com.springframe.springframe.model.form.AuxilioEmergencialForm;
import com.springframe.springframe.model.form.ConsultaAuxilioForm;
import com.springframe.springframe.model.form.UsuarioForm;
import com.springframe.springframe.security.UserDetailsServiceImpl;
import com.springframe.springframe.services.auxilioEmergencial.interfaces.iAuxlioEmergencialService;
import com.springframe.springframe.services.municipio.interfaces.iMunicipioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class IndexControllher {

    private UserDetailsServiceImpl userDetailsService;
    private iAuxlioEmergencialService auxlioEmergencialService;
    private iApiExterna apiExterna;

    public IndexControllher(UserDetailsServiceImpl userDetailsService, iAuxlioEmergencialService auxlioEmergencialService,
                            iApiExterna apiExterna){
        this.userDetailsService = userDetailsService;
        this.auxlioEmergencialService = auxlioEmergencialService;
        this.apiExterna = apiExterna;
    }

    @RequestMapping("/")
    public String index(Model model, ConsultaAuxilioForm consulta){
        model.addAttribute("consulta", consulta);
        List<AuxilioEmergencialDTO> auxilios = auxlioEmergencialService.listarAuxilios();
        model.addAttribute("auxilios", auxilios);
        return "/index";
    }

    @PostMapping("/busca")
    public String buscar(Model model, ConsultaAuxilioForm consulta){
        model.addAttribute("consulta", consulta);
        String anoMes = String.valueOf(consulta.getAno()) + String.valueOf(consulta.getMes());
        List<AuxilioEmergencialForm> auxilios = apiExterna.callApi(consulta.getCodigoIBGE(), anoMes);
        model.addAttribute("auxilios", auxilios);
        return "/index";
    }

}
