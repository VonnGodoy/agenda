package br.gdtech.agenda.persistence.impl;

import br.gdtech.agenda.model.ItemAtendimento;
import br.gdtech.agenda.persistence.generic.RepositorioBase;
import br.gdtech.agenda.persistence.repository.ItemAtendimentoRepository;
import org.jinq.jpa.JPAJinqStream;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ItemAtendimentoRepositoryImpl extends RepositorioBase<ItemAtendimento, Long> implements ItemAtendimentoRepository {

	public List<ItemAtendimento> listar(ItemAtendimento filtro) {

		JPAJinqStream<ItemAtendimento> streams = stream(ItemAtendimento.class);

		Long id = filtro.getId() != null ? filtro.getId() : null;
		Long idAtendimento = filtro.getAtendimento() != null ? filtro.getAtendimento().getId() : null;
		Long funcionarioId = filtro.getFuncionario() != null ? filtro.getFuncionario().getId() : null;
		Long servicoId = filtro.getServico() != null ? filtro.getServico().getId() : null;
		Long autorizadorId = filtro.getAutorizacao() != null ? filtro.getAutorizacao().getId() : null;

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

		return streams.toList();
	}


	@Override
	public List<ItemAtendimento> findAll() {
		return null;
	}

	@Override
	public Iterable<ItemAtendimento> findAllById(Iterable<Long> iterable) {
		return null;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void deleteById(Long aLong) {

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

	@Override
	public Optional<ItemAtendimento> findById(Long id) {
		return Optional.empty();
	}

	@Override
	public boolean existsById(Long aLong) {
		return false;
	}
}