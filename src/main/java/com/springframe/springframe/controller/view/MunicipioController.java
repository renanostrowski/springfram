package com.springframe.springframe.controller.view;

import com.springframe.springframe.model.dto.MunicipioDTO;
import com.springframe.springframe.model.dto.UnidadeFederativaDTO;
import com.springframe.springframe.model.form.MunicipioForm;
import com.springframe.springframe.services.municipio.interfaces.iMunicipioService;
import com.springframe.springframe.services.unidadeFederativa.interfaces.iUnidadeFedetativaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MunicipioController {


    private iMunicipioService municipioService;
    private iUnidadeFedetativaService unidadeFederativaService;

    public MunicipioController(iMunicipioService municipioService, iUnidadeFedetativaService unidadeFederativaService){
        this.municipioService = municipioService;
        this.unidadeFederativaService = unidadeFederativaService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "municipio/novo")
    public String form(Model model){
        model.addAttribute("form", new MunicipioForm());
        List<MunicipioDTO> municipios = municipioService.listarMunicipios();
        model.addAttribute("municipios", municipios);
        List<UnidadeFederativaDTO> ufDtos = unidadeFederativaService.findAll();
        model.addAttribute("ufs", ufDtos);
        return "/cadastros/municipio/form";
    }

    @PostMapping(value = "/municipio/salvar")
    public String salvarMunicipio(MunicipioForm municipioForm, BindingResult result, RedirectAttributes attr){
        if(result.hasErrors()){
            return "/cadastro/municipio/form";
        }
        municipioService.salvarMunicipio(municipioForm);
        return "/cadastro/municipio/form";
    }
}
