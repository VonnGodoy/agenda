package br.gdtech.agenda.repository;

import br.gdtech.agenda.model.ItemAtendimento;
import org.jinq.jpa.JPAJinqStream;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public abstract class ItemAtendimentoRepository extends RepositorioBase<ItemAtendimento> {

	public List<ItemAtendimento> listar(ItemAtendimento filtro) {

		JPAJinqStream<ItemAtendimento> streams = stream();

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

		return streams.toList();
	}

	public ItemAtendimento gravar(ItemAtendimento ag) {
		return this.save(ag);
	}

	public Optional<ItemAtendimento> buscarPorId(Integer id) {
		return this.findById(id);
	}

}