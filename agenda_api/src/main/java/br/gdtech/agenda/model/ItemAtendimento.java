package br.gdtech.agenda.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity(name = "item_atendimento")
public class ItemAtendimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_atendimento")
	private Atendimento atendimento;

	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data")
	private LocalDate data;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_funcionario")
	private Pessoa funcionario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_servico")
	private ProdutoServico servico;

	@Column(name = "desconto")
	private Double desconto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_autorizacao")
	private Pessoa autorizacao;

}
