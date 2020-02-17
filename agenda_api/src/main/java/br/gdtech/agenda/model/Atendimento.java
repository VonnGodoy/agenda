package br.gdtech.agenda.model;

import br.gdtech.agenda.enums.StatusAtendimentoEnum;
import br.gdtech.agenda.enums.TipoPagamentoEnum;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity(name = "atendimento")
public class Atendimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_atendimento")
	private Long id;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_agendamento")
	private Agendamento agendamento;

	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_hora")
	private LocalDate data;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_pagamento")
	private TipoPagamentoEnum tpPagamento;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private StatusAtendimentoEnum status;

	@Column(name = "verificadorCartao")
	private Integer verificadorCartao;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Column(name = "id_atendimento")
	private List<ItemAtendimento> itensAtendimento;

	@Transient
	private Double vrTotal;

	@Transient
	private LocalDate dataInicio;

	@Transient
	private LocalDate dataFim;

}
