package com.SEPLAG.projetoKanban.model;

public enum StatusTarefa {
	A_FAZER("A fazer"),
	EM_EXECUCAO("Em execução"),
	TERMINADO("Terminado");
	
	private String status;
	
	StatusTarefa(String status) {
		this.status = status;
		}
	
	public String getStatus()  {
		return status;
		
	}
}