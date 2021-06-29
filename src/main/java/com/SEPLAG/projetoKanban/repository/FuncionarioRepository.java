package com.SEPLAG.projetoKanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SEPLAG.projetoKanban.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
