package com.SEPLAG.projetoKanban.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.SEPLAG.projetoKanban.model.PrioridadeTarefa;
import com.SEPLAG.projetoKanban.model.StatusTarefa;
import com.SEPLAG.projetoKanban.model.Tarefa;
import com.SEPLAG.projetoKanban.repository.TarefaRepository;


@RestController
@RequestMapping("/tarefas")
public class TarefaController {
	
	@Autowired
	private TarefaRepository tarefas;
			
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroTarefa");
		mv.addObject("todosStatusTarefa", StatusTarefa.values());
		mv.addObject("todasPrioridadeTarefa", PrioridadeTarefa.values());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Tarefa tarefa) {
		tarefas.save(tarefa);
		
		ModelAndView mv = new ModelAndView("CadastroTarefa");
		mv.addObject("mensagem", "Tarefa salva com sucesso!");
		return mv;		
	}
	
	@RequestMapping
	public ModelAndView pesquisar() {
		List<Tarefa> todasTarefas = tarefas.findAll();
		ModelAndView mv = new ModelAndView("PesquisaTarefas");
		mv.addObject("tarefas", todasTarefas);
		return mv;
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
