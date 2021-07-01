package com.SEPLAG.projetoKanban.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.SEPLAG.projetoKanban.model.Funcionario;
import com.SEPLAG.projetoKanban.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarios;

	public Funcionario salvar(Funcionario funcionario) {

		return funcionarios.save(funcionario);
	}
		
	public Funcionario atualizar(Long id, Funcionario funcionario) {
		Funcionario funcionarioSalvo = buscarPeloId(id);
		
		return funcionarios.save(funcionarioSalvo);
	}
	
	public Funcionario buscarPeloId(Long id) {
		Funcionario funcionarioSalvo = funcionarios.findById(id).get();
		
		return funcionarioSalvo;
	}
	public Page<Funcionario> pesquisar(Pageable pageable){
		return funcionarios.findAll(pageable);
	}
	
	public List<Funcionario> listarTodos(){
		return funcionarios.findAll();
	}
	
	public void remover(Long id) {
		funcionarios.deleteById(id);
	}

}
