package br.gdtech.agenda.enums;

public enum TipoContatoEnum {
	
	CELULAR("Telefone Celular"),
	FIXO("Telefone Fixo"),
	EMAIL("E-Mail");

	private String nome;

	TipoContatoEnum(String nome){
		this.nome = nome;
	}

	public String getNome(){
		return this.nome;
	}

	public void setNome(String nome){
		this.nome = nome;
	}


}
