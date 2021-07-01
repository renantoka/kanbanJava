package com.SEPLAG.projetoKanban.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.SEPLAG.projetoKanban.model.PrioridadeTarefa;
import com.SEPLAG.projetoKanban.model.Projeto;
import com.SEPLAG.projetoKanban.model.StatusTarefa;
import com.SEPLAG.projetoKanban.model.Tarefa;
import com.SEPLAG.projetoKanban.repository.ProjetoRepository;
import com.SEPLAG.projetoKanban.service.TarefaService;


@RestController
@RequestMapping("/tarefas")
public class TarefaController {
	
	@Autowired
	private TarefaService tarefaService;
	
	@Autowired
	private ProjetoRepository projetos;
	
	@PostMapping
	public ResponseEntity<Tarefa> salvar(@RequestBody Tarefa tarefa, HttpServletResponse response) throws Exception {
		Projeto projeto = projetos.findById(tarefa.getProjeto().getId()).get();
		if (projeto == null) {
			throw new Exception("Não foi encontrado o id do projeto");
		}
		Tarefa tarefaSalvar = tarefaService.salvar(tarefa);
		return ResponseEntity.status(HttpStatus.CREATED).body(tarefaSalvar);		
	}
	
	@GetMapping
	public Page<Tarefa> pesquisar(Pageable pageable) {
		return tarefaService.pesquisar(pageable);
	}
	
	@GetMapping("/all")
	public List<Tarefa> pesquisar() {
		return tarefaService.listarTodos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tarefa> buscaPeloId(@PathVariable Long id) {
		Tarefa tarefa = tarefaService.buscarPeloId(id);
		return tarefa != null ? ResponseEntity.ok(tarefa) : ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Tarefa> atualizar(@PathVariable Long id, @RequestBody Tarefa tarefa) throws Exception {
		Tarefa tarefaSalvar = tarefaService.atualizar(id, tarefa);
		return ResponseEntity.ok(tarefaSalvar);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		tarefaService.remover(id);
	}
	
	@ModelAttribute("todasPrioridadeTarefa")
	public List<PrioridadeTarefa> todasPrioridadeTarefa() {
		return Arrays.asList(PrioridadeTarefa.values());
	}
	
	@ModelAttribute("todosStatusTarefa")
	public List<StatusTarefa> todosStatusTarefa() {
		return Arrays.asList(StatusTarefa.values());
	}

}

// View para testar cadastro de tarefa com HTML
//	@RequestMapping("/novo")
//	public ModelAndView novo() {
//		ModelAndView mv = new ModelAndView("CadastroTarefa");
//		mv.addObject("todosStatusTarefa", StatusTarefa.values());
//		mv.addObject("todasPrioridadeTarefa", PrioridadeTarefa.values());
//		return mv;
//	}

// view para testar pesquisa com html
//	@RequestMapping
//	public ModelAndView pesquisar() {
//		List<Tarefa> todasTarefas = tarefas.findAll();
//		ModelAndView mv = new ModelAndView("PesquisaTarefas");
//		mv.addObject("tarefas", todasTarefas);
//		return mv;
//	}