package com.SEPLAG.projetoKanban.model;

public enum StatusTarefa {
	A_FAZER("A fazer"),
	EM_EXECUCAO("Em execução"),
	TERMINADO("Terminado");
	
	private String descricao;
	
	StatusTarefa(String descricao) {
		this.descricao = descricao;
		}
	
	public String getDescricao()  {
		return descricao;
		
	}
}
