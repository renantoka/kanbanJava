package com.SEPLAG.projetoKanban.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.SEPLAG.projetoKanban.model.Projeto;
import com.SEPLAG.projetoKanban.repository.ProjetoRepository;

@Service
public class ProjetoService {

	@Autowired
	private ProjetoRepository projetos;

	public Projeto salvar(Projeto projeto) {

		return projetos.save(projeto);
	}
		
	public Projeto atualizar(Long id, Projeto projeto) {
		Projeto projetoSalvo = buscarPeloId(id);
		
		return projetos.save(projetoSalvo);
	}
	
	public Projeto buscarPeloId(Long id) {
		Projeto projetoSalvo = projetos.findById(id).get();
		
		return projetoSalvo;
	}
	public Page<Projeto> pesquisar(Pageable pageable){
		return projetos.findAll(pageable);
	}
	
	public List<Projeto> listarTodos(){
		return projetos.findAll();
	}
	
	public void remover(Long id) {
		projetos.deleteById(id);
	}

}
