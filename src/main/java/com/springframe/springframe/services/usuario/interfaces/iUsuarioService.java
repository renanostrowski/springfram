package com.springframe.springframe.services.usuario.interfaces;

import com.springframe.springframe.model.dto.UsuarioDTO;
import com.springframe.springframe.model.form.UsuarioForm;

public interface iUsuarioService {
    UsuarioDTO salvarUsuario(UsuarioForm usuarioForm);
}
