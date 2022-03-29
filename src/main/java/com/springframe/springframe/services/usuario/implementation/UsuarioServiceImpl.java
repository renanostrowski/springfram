package com.springframe.springframe.services.usuario.implementation;

import com.springframe.springframe.exceptions.CustomErrorType;
import com.springframe.springframe.model.dto.UsuarioDTO;
import com.springframe.springframe.model.entity.Usuario;
import com.springframe.springframe.model.form.UsuarioForm;
import com.springframe.springframe.repsository.iUsuarioRepository;
import com.springframe.springframe.services.usuario.interfaces.iUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements iUsuarioService {

    @Autowired
    private iUsuarioRepository usuarioReposity;

    public UsuarioDTO salvarUsuario(UsuarioForm usuarioForm) {
        Usuario usuario = buscaUsuarioEmail(usuarioForm.getEmail());
        if(usuario == null) {
            usuario = usuarioReposity.save(usuarioForm.convert());
            return new UsuarioDTO(usuario);
        } else {
            throw  new CustomErrorType("E-mail já cadastrado para outro usuário!");
        }

    }

    public void deletarUsuario(String email){
        Usuario usuario = buscaUsuarioEmail(email);
        if(usuario != null) {
            usuarioReposity.delete(usuario);
        } else {
            throw  new CustomErrorType("Usuário que deseja excluir não existe!");
        }
    }

    public List<UsuarioDTO> listarUsuarios(){
        List<Usuario> usuarios = usuarioReposity.findAll();
        return usuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    public Usuario buscaUsuarioEmail(String email) {
        Usuario usuario = usuarioReposity.buscarPorEmail(email);
        return usuario;
    }
}
