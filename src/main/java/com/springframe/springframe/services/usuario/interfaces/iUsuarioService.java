package com.springframe.springframe.services.usuario.interfaces;

import com.springframe.springframe.model.dto.UsuarioDTO;
import com.springframe.springframe.model.entity.Usuario;
import com.springframe.springframe.model.form.UsuarioForm;

import java.util.List;

public interface iUsuarioService {
    UsuarioDTO salvarUsuario(UsuarioForm usuarioForm);
    void deletarUsuario(String email);
    List<UsuarioDTO> listarUsuarios();
    Usuario buscaUsuarioEmail(String email);
}
