package com.springframe.springframe.repsository;

import com.springframe.springframe.model.entity.UnidadeFederativa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface iUnidadeFederativaRepository extends JpaRepository<UnidadeFederativa, Long> {
    UnidadeFederativa findById(long id);
}
