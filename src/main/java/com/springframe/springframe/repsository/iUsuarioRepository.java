package com.springframe.springframe.repsository;

import com.springframe.springframe.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iUsuarioRepository extends JpaRepository<Usuario, Long> {

}
