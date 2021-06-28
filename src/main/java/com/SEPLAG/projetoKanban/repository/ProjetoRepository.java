package com.SEPLAG.projetoKanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SEPLAG.projetoKanban.model.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

}
