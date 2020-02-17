package br.gdtech.agenda.enums;

public enum StatusAtendimentoEnum {

	AGENDADO("Agendado"),
	PENDENTE("Pendente"),
	CONCLUIDO("Concluido"),
	CANCELADO("Cancelado");

	private String nome;

	StatusAtendimentoEnum(String nome){
		this.nome = nome;
	}

	public String getNome(){
		return this.nome;
	}

	public void setNome(String nome){
		this.nome = nome;
	}

}
