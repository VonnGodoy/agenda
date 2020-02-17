package br.gdtech.agenda.enums;

public enum TipoPagamentoEnum {

	DINHEIRO("Dinheiro"),
	CARTAO_DEBITO("Cartão Débito"),
	CARTAO_CREDITO("Cartão Crédito"),
	FATURADO("Faturado");

	private String nome;

	TipoPagamentoEnum(String nome){
		this.nome = nome;
	}

	public String getNome(){
		return this.nome;
	}

	public void setNome(String nome){
		this.nome = nome;
	}
}
