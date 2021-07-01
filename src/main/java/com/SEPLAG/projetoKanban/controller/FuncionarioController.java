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

import com.SEPLAG.projetoKanban.model.Funcionario;
import com.SEPLAG.projetoKanban.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
			
	@PostMapping
	public ResponseEntity<Funcionario> salvar(@RequestBody Funcionario funcionario, HttpServletResponse response) {
		Funcionario funcionarioSalvar = funcionarioService.salvar(funcionario);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioSalvar);		
	}
	
	@GetMapping
	public Page<Funcionario> pesquisar(Pageable pageable) {
		return funcionarioService.pesquisar(pageable);
	}
	
	@GetMapping("/all")
	public List<Funcionario> pesquisar() {
		return funcionarioService.listarTodos();
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> buscaPeloId(@PathVariable Long id) {
		Funcionario funcionario = funcionarioService.buscarPeloId(id);
		return funcionario != null ? ResponseEntity.ok(funcionario) : ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Funcionario> atualizar(@PathVariable Long id, @RequestBody Funcionario funcionario) {
		Funcionario funcionarioSalvar = funcionarioService.atualizar(id, funcionario);
		return ResponseEntity.ok(funcionarioSalvar);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long id) {
		funcionarioService.remover(id);
	}
	
	
}