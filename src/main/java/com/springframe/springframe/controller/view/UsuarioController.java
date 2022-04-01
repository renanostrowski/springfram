package com.springframe.springframe.controller.view;

import com.springframe.springframe.exceptions.CustomErrorType;
import com.springframe.springframe.model.dto.MunicipioDTO;
import com.springframe.springframe.model.dto.UsuarioDTO;
import com.springframe.springframe.model.entity.Municipio;
import com.springframe.springframe.model.entity.Usuario;
import com.springframe.springframe.model.form.UsuarioForm;
import com.springframe.springframe.services.municipio.interfaces.iMunicipioService;
import com.springframe.springframe.services.usuario.interfaces.iUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private iUsuarioService iUsuarioService;
    @Autowired
    private iMunicipioService municipioService;


    @RequestMapping(method = RequestMethod.GET, value = "/novo")
    public String form(Model model){
        UsuarioForm usuarioForm = new UsuarioForm();
        model.addAttribute("formUser", usuarioForm);
        List<MunicipioDTO> municipioDTOS = municipioService.listarMunicipios();
        model.addAttribute("municipios", municipioDTOS);
        model.addAttribute("usuario", new UsuarioForm());
        return "/cadastros/usuario/form";
    }

    @PostMapping(value = "/salvar")
    public String salvarUsuario(@Valid UsuarioForm usuarioForm, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "/cadastros/usuario/form";
        }
        try{
            iUsuarioService.salvarUsuario(usuarioForm);
        } catch (CustomErrorType e){
            model.addAttribute("error", e.getMessage());
            model.addAttribute("formUser", usuarioForm);
            List<MunicipioDTO> municipioDTOS = municipioService.listarMunicipios();
            model.addAttribute("municipios", municipioDTOS);
            model.addAttribute("usuario", usuarioForm);
            return "/cadastros/usuario/form";
        } catch (Exception e){
            model.addAttribute("error", "Erro não tratado!");
            model.addAttribute("formUser", usuarioForm);
            List<MunicipioDTO> municipioDTOS = municipioService.listarMunicipios();
            model.addAttribute("municipios", municipioDTOS);
            model.addAttribute("usuario", usuarioForm);
            return "/cadastros/usuario/form";
        }

        return "redirect:/list";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/usuario/alterar/{email}")
    public String alterarUsuario(@PathVariable("email") String email, Model model) {
        UsuarioForm usuarioForm = iUsuarioService.alterarUsuario(email);

        model.addAttribute("formUser", usuarioForm);
        List<MunicipioDTO> municipioDTOS = municipioService.listarMunicipios();
        model.addAttribute("municipios", municipioDTOS);
        model.addAttribute("usuario", new UsuarioForm());

        return "/cadastros/usuario/form";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/usuario/deletar/{email}")
    public String deletarUsuario(@PathVariable("email") String email) {
        UsuarioDTO usuario = iUsuarioService.buscaUsuarioEmail(email);

        if(usuario != null) iUsuarioService.deletarUsuario(email);

        return "redirect:/list";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ModelAndView listarUsuarios(Model model){
        ModelAndView mView = new ModelAndView("/cadastros/usuario/list");
        List<UsuarioDTO> usuarios = iUsuarioService.listarUsuarios();
        mView.addObject("usuarios", usuarios);
        return mView;
    }
}
