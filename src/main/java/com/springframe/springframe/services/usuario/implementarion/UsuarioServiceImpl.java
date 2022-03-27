package com.springframe.springframe.services.usuario.implementarion;

import com.springframe.springframe.model.dto.UsuarioDTO;
import com.springframe.springframe.model.entity.Usuario;
import com.springframe.springframe.model.form.UsuarioForm;
import com.springframe.springframe.repsository.iUsuarioRepository;
import com.springframe.springframe.services.usuario.interfaces.iUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements iUsuarioService {

    @Autowired
    private iUsuarioRepository usuarioReposity;

    public UsuarioDTO salvarUsuario(UsuarioForm usuarioForm) {
        Usuario usuario = usuarioReposity.save(usuarioForm.convert());
        return new UsuarioDTO(usuario);
    }
}
