package com.springframe.springframe.controller.view;

import com.springframe.springframe.model.dto.UsuarioDTO;
import com.springframe.springframe.model.entity.Usuario;
import com.springframe.springframe.model.form.UsuarioForm;
import com.springframe.springframe.services.usuario.interfaces.iUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.naming.Binding;
import javax.validation.Valid;

@Controller
public class UsuarioController {

    @Autowired
    private iUsuarioService iUsuarioService;

    @RequestMapping(method = RequestMethod.GET, value = "/cadastrousuario")
    public String index(){
        return "/cadastros/usuario/cadastrousuario";
    }

    @PostMapping(value = "cadastrarUsuario")
    public String salvarUsuario(@Valid Usuario usuarioForm, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "/cadastros/usuario/cadastrousuario";
        }
        iUsuarioService.salvarUsuario(new UsuarioForm(usuarioForm));
        return "/cadastros/usuario/cadastrousuario";
    }
}
