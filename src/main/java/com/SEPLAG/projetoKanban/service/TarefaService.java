package com.SEPLAG.projetoKanban.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.SEPLAG.projetoKanban.model.Tarefa;
import com.SEPLAG.projetoKanban.repository.TarefaRepository;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository tarefas;

	public Tarefa salvar(Tarefa tarefa) {

		return tarefas.save(tarefa);
	}
	
	public Page<Tarefa> pesquisar(Pageable pageable){
		return tarefas.findAll(pageable);
	}
	
	public List<Tarefa> listarTodos(){
		return tarefas.findAll();
	}
	
	public void remover(Long id) {
		tarefas.deleteById(id);
	}
}
