package br.gdtech.agenda.enums;

public enum PerfilEnum {

	ADMINISTRADOR("Administrador"),
	GERENTE("Gerente"),
	ATENDENTE("Atendente"),
	USUARIO("Usuário");

	private String nome;

	PerfilEnum(String nome){
		this.nome = nome;
	}

	public String getNome(){
		return this.nome;
	}

	public void setNome(String nome){
		this.nome = nome;
	}
}
