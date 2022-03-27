package com.springframe.springframe.services.usuario.implementarion;

import com.springframe.springframe.model.dto.UsuarioDTO;
import com.springframe.springframe.model.entity.Usuario;
import com.springframe.springframe.model.form.UsuarioForm;
import com.springframe.springframe.repsository.iUsuarioRepository;
import com.springframe.springframe.services.usuario.interfaces.iUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements iUsuarioService {

    @Autowired
    private iUsuarioRepository usuarioReposity;

    public UsuarioDTO salvarUsuario(UsuarioForm usuarioForm) {
        Usuario usuario = usuarioReposity.save(usuarioForm.convert());
        return new UsuarioDTO(usuario);
    }

    public void deletarUsuario(String email){
        Usuario usuario = buscaUsuarioEmail(email);
        if(usuario != null) {
            usuarioReposity.delete(usuario);
        }
    }

    public List<UsuarioDTO> listarUsuarios(){
        List<Usuario> usuarios = usuarioReposity.findAll();
        return usuarios.stream().map(u -> new UsuarioDTO(u)).collect(Collectors.toList());
    }

    public Usuario buscaUsuarioEmail(String email) {
        Usuario usuario = usuarioReposity.buscarPorEmail(email);
        if (usuario == null) {
            throw new IllegalArgumentException("Pessoa inválida.");
        }

        return usuario;
    }
}
