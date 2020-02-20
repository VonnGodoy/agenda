package br.gdtech.agenda.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "tipo_movimentacao")
public class TipoMovimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_movimento")
    private Integer id;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "ativo")
    private Boolean ativo;

}
