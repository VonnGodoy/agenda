package br.gdtech.agenda.repository;

import br.gdtech.agenda.model.TipoMovimentacao;
import org.jinq.jpa.JPAJinqStream;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public abstract class TipoMovimentacaoRepository extends RepositorioBase<TipoMovimentacao> {

	public List<TipoMovimentacao> listar(TipoMovimentacao filtro) {

		JPAJinqStream<TipoMovimentacao> streams = stream();

		Integer id = filtro.getId() != null ? filtro.getId() : null;
		String nome = filtro.getTipo() != null ? filtro.getTipo() : null;
		Boolean ativo = filtro.getAtivo() != null ? filtro.getAtivo() : null;

		if (id != null)
			streams = streams.where(a -> a.getId().equals(id));
		if (nome != null)
			streams = streams.where(a -> a.getTipo().equals(nome));
		if (ativo != null)
			streams = streams.where(a -> a.getAtivo().equals(ativo));

		return streams.toList();
	}

	public TipoMovimentacao gravar(TipoMovimentacao ag) {
		return this.save(ag);
	}

	public Optional<TipoMovimentacao> buscarPorId(Integer id) {
		return this.findById(id);
	}
}
