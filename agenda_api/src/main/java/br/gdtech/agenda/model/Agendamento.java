package br.gdtech.agenda.model;

import br.gdtech.agenda.enums.StatusAtendimentoEnum;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity(name = "agendamento")
public class Agendamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_agendamento")
	private Integer id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_pessoa")
	private Pessoa cliente;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_hora")
	private LocalDate data;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="registro")
	private LocalDate registro;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private StatusAtendimentoEnum status;
	
	@Transient
	private LocalDate dataInicio;
	
	@Transient
	private LocalDate dataFim;
	
}
