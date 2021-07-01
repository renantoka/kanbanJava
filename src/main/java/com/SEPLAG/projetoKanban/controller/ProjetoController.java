package com.SEPLAG.projetoKanban.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.SEPLAG.projetoKanban.model.Projeto;
import com.SEPLAG.projetoKanban.service.ProjetoService;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {
	
	@Autowired
	private ProjetoService projetoService;
			
	@PostMapping
	public ResponseEntity<Projeto> salvar(@RequestBody Projeto projeto, HttpServletResponse response) {
		Projeto projetoSalvar = projetoService.salvar(projeto);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(projetoSalvar);		
	}
	
	@GetMapping
	public Page<Projeto> pesquisar(Pageable pageable) {
		return projetoService.pesquisar(pageable);
	}
	
	@GetMapping("/all")
	public List<Projeto> pesquisar() {
		return projetoService.listarTodos();
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Projeto> buscaPeloId(@PathVariable Long id) {
		Projeto projeto = projetoService.buscarPeloId(id);
		return projeto != null ? ResponseEntity.ok(projeto) : ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Projeto> atualizar(@PathVariable Long id, @RequestBody Projeto tarefa) {
		Projeto tarefaSalvar = projetoService.atualizar(id, tarefa);
		return ResponseEntity.ok(tarefaSalvar);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		projetoService.remover(id);
	}
	
	
}
	
// Descomentar para ter a visualização em HTML simples
	
//	@RequestMapping("/novo")
//	public ModelAndView novo() {
//		ModelAndView mv = new ModelAndView("CadastroProjeto");
//		return mv;
//	} 
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
