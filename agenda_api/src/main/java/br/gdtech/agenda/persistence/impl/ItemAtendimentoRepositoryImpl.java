package br.gdtech.agenda.persistence.impl;

import br.gdtech.agenda.model.ItemAtendimento;
import br.gdtech.agenda.persistence.generic.RepositorioBase;
import br.gdtech.agenda.persistence.repository.ItemAtendimentoRepository;
import org.jinq.jpa.JPAJinqStream;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ItemAtendimentoRepositoryImpl extends RepositorioBase<ItemAtendimento, Integer> implements ItemAtendimentoRepository {

	public List<ItemAtendimento> listar(ItemAtendimento filtro) {
		JPAJinqStream<ItemAtendimento> streams = montarFiltros(filtro);

		return streams.toList();
	}

	public long count(ItemAtendimento filtro) {
		JPAJinqStream<ItemAtendimento> streams = montarFiltros(filtro);

		return streams.count();
	}

	public Optional<ItemAtendimento> findById(Integer id) {
		JPAJinqStream<ItemAtendimento> streams = stream(ItemAtendimento.class);
		streams = streams.where(a -> a.getId().equals(id));

		return streams.findOne();
	}

	public boolean existsById(Integer id) {
		JPAJinqStream<ItemAtendimento> streams = stream(ItemAtendimento.class);
		streams = streams.where(a -> a.getId().equals(id));

		return streams.count() > 0 ? true : false;
	}

	private JPAJinqStream<ItemAtendimento> montarFiltros(ItemAtendimento filtro){
		JPAJinqStream<ItemAtendimento> streams = stream(ItemAtendimento.class);

		Integer id = filtro.getId() != null ? filtro.getId() : null;
		Integer idAtendimento = filtro.getAtendimento() != null ? filtro.getAtendimento().getId() : null;
		Integer funcionarioId = filtro.getFuncionario() != null ? filtro.getFuncionario().getId() : null;
		Integer servicoId = filtro.getServico() != null ? filtro.getServico().getId() : null;
		Integer autorizadorId = filtro.getAutorizacao() != null ? filtro.getAutorizacao().getId() : null;

		if (id != null)
			streams = streams.where(a -> a.getId().equals(id));
		if (idAtendimento != null)
			streams = streams.where(a -> a.getAtendimento().getId().equals(idAtendimento));
		if (funcionarioId != null)
			streams = streams.where(a -> a.getFuncionario().getId().equals(funcionarioId));
		if (servicoId != null)
			streams = streams.where(a -> a.getServico().getId().equals(servicoId));
		if (autorizadorId != null)
			streams = streams.where(a -> a.getAutorizacao().getId().equals(autorizadorId));

		return streams;
	}

	@Override
	public List<ItemAtendimento> findAll() {
		return null;
	}

	@Override
	public Iterable<ItemAtendimento> findAllById(Iterable<Integer> iterable) {
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
	public void delete(ItemAtendimento itemAtendimento) {

	}

	@Override
	public void deleteAll(Iterable<? extends ItemAtendimento> iterable) {

	}

	@Override
	public void deleteAll() {

	}

	@Override
	public <S extends ItemAtendimento> S save(S s) {
		return null;
	}

	@Override
	public <S extends ItemAtendimento> Iterable<S> saveAll(Iterable<S> iterable) {
		return null;
	}
}