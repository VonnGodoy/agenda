package br.gdtech.agenda.model;

import br.gdtech.agenda.enums.PerfilEnum;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity(name = "pessoa")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pessoa")
	private Integer id;

	@Column(name = "cpfCnpj", unique = true, nullable = false)
	private String cpfCnpj;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "senha", nullable = false)
	private String senha;

	@Column(name = "comissao")
	private Integer comissao;

	@Column(name = "ativo")
	private Boolean ativo;

	@Enumerated(EnumType.STRING)
	@Column(name = "perfil", nullable = false)
	private PerfilEnum perfil;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_nascimento")
	private LocalDate dtNascimento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_cadastro", nullable = false)
	private LocalDate dtCadastro;

	@Transient
	private String repetirSenha;
	
	@Transient
	private Integer mes;

}
