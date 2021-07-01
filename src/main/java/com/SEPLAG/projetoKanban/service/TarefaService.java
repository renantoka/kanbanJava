package com.SEPLAG.projetoKanban.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

	public Tarefa atualizar(Long id, Tarefa tarefa) throws Exception {
		Tarefa tarefaSave = buscarPeloId(id);

		if (tarefa == null) {
			throw new Exception("A tarefa não existe");
		}

		BeanUtils.copyProperties(tarefa, tarefaSave, "id");
		return tarefas.save(tarefaSave);
	}

	public Tarefa buscarPeloId(Long id) {
		Tarefa tarefaserviceSalva = tarefas.findById(id).get();
		if (tarefaserviceSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return tarefaserviceSalva;
	}

	public Page<Tarefa> pesquisar(Pageable pageable) {
		return tarefas.findAll(pageable);
	}

	public List<Tarefa> listarTodos() {
		return tarefas.findAll();
	}

	public void remover(Long id) {
		tarefas.deleteById(id);
	}
}
