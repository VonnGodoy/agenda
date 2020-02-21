package br.gdtech.agenda.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "item_atendimento")
public class ItemAtendimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item")
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_atendimento")
	private Atendimento atendimento;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_funcionario")
	private Pessoa funcionario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_servico")
	private ProdutoServico servico;

	@Column(name = "desconto")
	private Double desconto;

	@Column(name = "valor")
	private Double valor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_autorizacao")
	private Pessoa autorizacao;

}
