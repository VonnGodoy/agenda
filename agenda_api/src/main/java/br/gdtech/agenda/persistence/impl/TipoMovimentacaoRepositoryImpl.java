package br.gdtech.agenda.persistence.impl;

import br.gdtech.agenda.model.TipoMovimentacao;
import br.gdtech.agenda.persistence.generic.RepositorioBase;
import br.gdtech.agenda.persistence.repository.TipoMovimentacaoRepository;
import org.jinq.jpa.JPAJinqStream;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TipoMovimentacaoRepositoryImpl extends RepositorioBase<TipoMovimentacao, Integer> implements TipoMovimentacaoRepository {

	public List<TipoMovimentacao> listar(TipoMovimentacao filtro) {
		JPAJinqStream<TipoMovimentacao> streams = montarFiltros(filtro);

		return streams.toList();
	}

	public Optional<TipoMovimentacao> findById(Integer id) {
		JPAJinqStream<TipoMovimentacao> streams = stream(TipoMovimentacao.class);
		streams = streams.where(a -> a.getId().equals(id));

		return streams.findOne();
	}

	public boolean existsById(Integer id) {
		JPAJinqStream<TipoMovimentacao> streams = stream(TipoMovimentacao.class);
		streams = streams.where(a -> a.getId().equals(id));

		return streams.count() > 0 ? true : false;
	}

	public long count(TipoMovimentacao filtro) {
		JPAJinqStream<TipoMovimentacao> streams = montarFiltros(filtro);

		return streams.count();
	}


	private JPAJinqStream<TipoMovimentacao> montarFiltros(TipoMovimentacao filtro){
		JPAJinqStream<TipoMovimentacao> streams = stream(TipoMovimentacao.class);

		Integer id = filtro.getId() != null ? filtro.getId() : null;
		String nome = filtro.getTipo() != null ? filtro.getTipo() : null;
		Boolean ativo = filtro.getAtivo() != null ? filtro.getAtivo() : null;

		if (id != null)
			streams = streams.where(a -> a.getId().equals(id));
		if (nome != null)
			streams = streams.where(a -> a.getTipo().equals(nome));
		if (ativo != null)
			streams = streams.where(a -> a.getAtivo().equals(ativo));

		return streams;
	}
	@Override
	public List<TipoMovimentacao> findAll() {
		return null;
	}

	@Override
	public Iterable<TipoMovimentacao> findAllById(Iterable<Integer> iterable) {
		return null;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void deleteById(Integer integer) {

	}

	@Override
	public void delete(TipoMovimentacao tipoMovimentacao) {

	}

	@Override
	public void deleteAll(Iterable<? extends TipoMovimentacao> iterable) {

	}

	@Override
	public void deleteAll() {

	}

	@Override
	public <S extends TipoMovimentacao> S save(S s) {
		return null;
	}

	@Override
	public <S extends TipoMovimentacao> Iterable<S> saveAll(Iterable<S> iterable) {
		return null;
	}

}
