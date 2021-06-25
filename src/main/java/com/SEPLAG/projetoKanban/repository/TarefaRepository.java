package com.SEPLAG.projetoKanban.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SEPLAG.projetoKanban.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}
