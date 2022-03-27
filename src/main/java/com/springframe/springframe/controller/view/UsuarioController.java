package com.springframe.springframe.controller.view;

import com.springframe.springframe.model.dto.UsuarioDTO;
import com.springframe.springframe.model.entity.Usuario;
import com.springframe.springframe.model.form.UsuarioForm;
import com.springframe.springframe.services.usuario.interfaces.iUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private iUsuarioService iUsuarioService;

    @RequestMapping(method = RequestMethod.GET, value = "/novo")
    public String index(@ModelAttribute("usuario") UsuarioForm usuarioForm){
        return "/cadastros/usuario/formuser";
    }

    @PostMapping(value = "/salvar")
    public String salvarUsuario(@Valid Usuario usuarioForm, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "/cadastros/usuario/novo";
        }
        iUsuarioService.salvarUsuario(new UsuarioForm(usuarioForm));
        return "redirect:/listarusuarios";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listarusuarios")
    public ModelAndView listarUsuarios(){
        ModelAndView mView = new ModelAndView("/cadastros/usuario/listarusuario");
        List<UsuarioDTO> usuarios = iUsuarioService.listarUsuarios();
        mView.addObject("usuarios", usuarios);
        return mView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/usuario/alterar/{email}")
    public String alterarUsuario(@PathVariable("email") String email, Model model) {
        Usuario usuarioDTO = iUsuarioService.buscaUsuarioEmail(email);

        model.addAttribute("usuario", usuarioDTO);

        return "/cadastros/usuario/formuser";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/usuario/deletar/{email}")
    public String deletarUsuario(@PathVariable("email") String email) {
        Usuario usuario = iUsuarioService.buscaUsuarioEmail(email);

        if(usuario != null) iUsuarioService.deletarUsuario(email);

        return "redirect:/listarusuarios";
    }
}
