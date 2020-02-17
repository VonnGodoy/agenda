package br.gdtech.agenda.enums;

public enum TipoEnderecoEnum {

	COBRANCA("Cobrança"),
	COMERCIAL("Comercial"),
	RESIDENCIAL("Residencial");

	private String nome;

	TipoEnderecoEnum(String nome){
		this.nome = nome;
	}

	public String getNome(){
		return this.nome;
	}

	public void setNome(String nome){
		this.nome = nome;
	}
}

