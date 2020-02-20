package br.gdtech.agenda.persistence.impl;

import br.gdtech.agenda.enums.TipoPagamentoEnum;
import br.gdtech.agenda.model.Movimentacao;
import br.gdtech.agenda.persistence.generic.RepositorioBase;
import br.gdtech.agenda.persistence.repository.MovimentacaoRepository;
import org.jinq.jpa.JPAJinqStream;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class MovimentacaoRepositoryImpl extends RepositorioBase<Movimentacao, Integer> implements MovimentacaoRepository {

	public List<Movimentacao> listar(Movimentacao filtro) {
		JPAJinqStream<Movimentacao> streams = montarFiltros(filtro);

		return streams.toList();
	}

	public Optional<Movimentacao> findById(Integer id) {
		JPAJinqStream<Movimentacao> streams = stream(Movimentacao.class);
		streams = streams.where(a -> a.getId().equals(id));

		return streams.findOne();
	}

	public boolean existsById(Integer id) {
		JPAJinqStream<Movimentacao> streams = stream(Movimentacao.class);
		streams = streams.where(a -> a.getId().equals(id));

		return streams.count() > 0 ? true : false;
	}

	public long count(Movimentacao filtro) {
		JPAJinqStream<Movimentacao> streams = montarFiltros(filtro);

		return streams.count();
	}

	private JPAJinqStream<Movimentacao> montarFiltros(Movimentacao filtro){
		JPAJinqStream<Movimentacao> streams = stream(Movimentacao.class);

		Integer id = filtro.getId() != null ? filtro.getId() : null;
		Integer tpMovimentoId = filtro.getTpMovimento() != null ? filtro.getTpMovimento().getId() : null;
		TipoPagamentoEnum tpPagamento = filtro.getTpPagamento() != null ? filtro.getTpPagamento() : null;
		Integer usuarioId = filtro.getUsuario() != null ? filtro.getUsuario().getId() : null;
		LocalDate dataInicio = filtro.getDataInicio() != null ? filtro.getDataInicio() : null;
		LocalDate dataFim = filtro.getDataFim() != null ? filtro.getDataFim() : null;

		if (id != null)
			streams = streams.where(a -> a.getId().equals(id));
		if (tpMovimentoId != null)
			streams = streams.where(a -> a.getTpMovimento().getId().equals(tpMovimentoId));
		if (tpPagamento != null)
			streams = streams.where(a -> a.getTpPagamento().equals(tpPagamento));
		if (usuarioId != null)
			streams = streams.where(a -> a.getUsuario().getId().equals(usuarioId));
		if (dataInicio != null && dataFim == null)
			streams = streams.where(a -> a.getData().isEqual(dataInicio));
		if (dataInicio != null && dataFim != null)
			streams = streams.where(a -> a.getData().isAfter(dataInicio) && a.getData().isBefore(dataFim));

		return streams;
	}

	@Override
	public List<Movimentacao> findAll() {
		return null;
	}

	@Override
	public Iterable<Movimentacao> findAllById(Iterable<Integer> iterable) {
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
	public void delete(Movimentacao movimentacao) {

	}

	@Override
	public void deleteAll(Iterable<? extends Movimentacao> iterable) {

	}

	@Override
	public void deleteAll() {

	}

	@Override
	public <S extends Movimentacao> S save(S s) {
		return null;
	}

	@Override
	public <S extends Movimentacao> Iterable<S> saveAll(Iterable<S> iterable) {
		return null;
	}
}