package br.gdtech.agenda.model;

import br.gdtech.agenda.enums.TipoContatoEnum;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "contato")
public class Contato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_contato")
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_contato")
	private TipoContatoEnum tipo;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "principal")
	private Boolean principal;

	@Column(name = "whats_app")
	private Boolean whatsApp;

}
