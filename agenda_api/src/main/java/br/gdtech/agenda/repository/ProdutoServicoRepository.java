package br.gdtech.agenda.repository;

import br.gdtech.agenda.model.ProdutoServico;
import org.jinq.jpa.JPAJinqStream;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public abstract class ProdutoServicoRepository extends RepositorioBase<ProdutoServico> {

	public List<ProdutoServico> listar(ProdutoServico filtro) {

		JPAJinqStream<ProdutoServico> streams = stream();

		Integer id = filtro.getId() != null ? filtro.getId() : null;
		String nome = filtro.getServico() != null ? filtro.getServico() : null;
		Boolean ativo = filtro.getAtivo() != null ? filtro.getAtivo() : null;

		if (id != null)
			streams = streams.where(a -> a.getId().equals(id));
		if (nome != null)
			streams = streams.where(a -> a.getServico().equals(nome));
		if (ativo != null)
			streams = streams.where(a -> a.getAtivo().equals(ativo));

		return streams.toList();
	}

	public ProdutoServico gravar(ProdutoServico ag) {
		return this.save(ag);
	}

	public Optional<ProdutoServico> buscarPorId(Integer id) {
		return this.findById(id);
	}
}
