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
			streams = streams.where(a -> a.getId() == id);
		if (idAtendimento != null)
			streams = streams.where(a -> a.getAtendimento().getId() == idAtendimento);
		if (funcionarioId != null)
			streams = streams.where(a -> a.getFuncionario().getId() == funcionarioId);
		if (servicoId != null)
			streams = streams.where(a -> a.getServico().getId() == servicoId);
		if (autorizadorId != null)
			streams = streams.where(a -> a.getAutorizacao().getId() == autorizadorId);

		return streams;
	}

}