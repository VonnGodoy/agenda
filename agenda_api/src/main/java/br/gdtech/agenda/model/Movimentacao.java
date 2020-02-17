package br.gdtech.agenda.model;

import br.gdtech.agenda.enums.TipoPagamentoEnum;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity(name = "movimentacao")
public class Movimentacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_movimento")
	private Long id;

	@Column(name = "vr_movimento")
	private Double valor;

	@ManyToOne
	@JoinColumn(name = "id_tipo_movimento")
	private TipoMovimentacao tpMovimento;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_pagamento")
	private TipoPagamentoEnum tpPagamento;

	@ManyToOne
	@JoinColumn(name = "id_pessoa")
	private Pessoa usuario;

	@Column(name = "motivo")
	private String motivo;

	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data")
	private LocalDate data;

	@Transient
	private LocalDate dataInicio;

	@Transient
	private LocalDate dataFim;

}
