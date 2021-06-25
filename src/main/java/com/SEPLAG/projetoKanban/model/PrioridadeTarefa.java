package com.SEPLAG.projetoKanban.model;

public enum PrioridadeTarefa {
	BAIXA("Baixa"),
	MEDIA("Média"),
	ALTA("Alta");
	
	private String prioridade;
	
	PrioridadeTarefa(String prioridade) {
		this.prioridade = prioridade;
		}
	
	public String getPrioridade()  {
		return prioridade;
		
	}
}
