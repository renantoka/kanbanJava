package com.SEPLAG.projetoKanban.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.SEPLAG.projetoKanban.model.Projeto;
import com.SEPLAG.projetoKanban.model.Projeto;
import com.SEPLAG.projetoKanban.repository.ProjetoRepository;
import com.SEPLAG.projetoKanban.service.ProjetoService;


@RestController
@RequestMapping("/projetos")
public class ProjetoController {
	
	@Autowired
	private ProjetoService projetoService;
	
	@Autowired
	private ProjetoRepository projetos;
			
	@GetMapping("/all")
	public ResponseEntity<List<Projeto>> pesquisar() {
		List<Projeto> todosProjetos = (List<Projeto>) projetos.findAll();
		return new ResponseEntity<List<Projeto>>(todosProjetos, HttpStatus.OK);
	}
	
	
// Descomentar para ter a visualização em HTML simples
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroProjeto");
		return mv;
	}
	
	@PostMapping
	public ResponseEntity<Projeto>salvar(@RequestBody Projeto projeto, HttpServletResponse response) {
		Projeto projetoSalvar = projetoService.salvar(projeto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(projetoSalvar);		
	}
//	@RequestMapping(method = RequestMethod.POST)
//	public ModelAndView salvar(Projeto projeto) {
//		projetos.save(projeto);
//		
//		ModelAndView mv = new ModelAndView("CadastroProjeto");
//		mv.addObject("mensagem", "Projeto salvo com sucesso!");
//		return mv;		
//	}
//	
//	@RequestMapping
//	public ModelAndView pesquisar() {
//		List<Projeto> todosProjetos = projetos.findAll();
//		ModelAndView mv = new ModelAndView("PesquisaProjetos");
//		mv.addObject("projetos", todosProjetos);
//		return mv;
//	}
	
}
