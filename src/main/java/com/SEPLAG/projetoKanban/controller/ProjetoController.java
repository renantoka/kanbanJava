package com.SEPLAG.projetoKanban.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.SEPLAG.projetoKanban.model.Projeto;
import com.SEPLAG.projetoKanban.repository.ProjetoRepository;


@RestController
@RequestMapping("/projetos")
public class ProjetoController {
	
	@Autowired
	private ProjetoRepository projetos;
			
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroProjeto");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Projeto projeto) {
		projetos.save(projeto);
		
		ModelAndView mv = new ModelAndView("CadastroProjeto");
		mv.addObject("mensagem", "Projeto salvo com sucesso!");
		return mv;		
	}
	
	@RequestMapping
	public ModelAndView pesquisar() {
		List<Projeto> todosProjetos = projetos.findAll();
		ModelAndView mv = new ModelAndView("PesquisaProjetos");
		mv.addObject("projetos", todosProjetos);
		return mv;
	}
	
}
