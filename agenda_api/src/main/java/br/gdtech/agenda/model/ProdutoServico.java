package br.gdtech.agenda.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "servico")
public class ProdutoServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servico")
    private Long id;

    @Column(name = "servico")
    private String servico;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "ativo")
    private Boolean ativo;
}
