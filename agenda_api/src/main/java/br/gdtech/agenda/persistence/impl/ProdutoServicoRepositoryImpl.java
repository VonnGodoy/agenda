package br.gdtech.agenda.persistence.impl;

import br.gdtech.agenda.model.ProdutoServico;
import br.gdtech.agenda.persistence.generic.RepositorioBase;
import br.gdtech.agenda.persistence.repository.ProdutoServicoRepository;
import org.jinq.jpa.JPAJinqStream;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProdutoServicoRepositoryImpl extends RepositorioBase<ProdutoServico, Long> implements ProdutoServicoRepository {

	public List<ProdutoServico> listar(ProdutoServico filtro) {

		JPAJinqStream<ProdutoServico> streams = stream(ProdutoServico.class);

		Long id = filtro.getId() != null ? filtro.getId() : null;
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

	public Optional<ProdutoServico> buscarPorId(Long id) {
		return this.findById(id);
	}

	@Override
	public List<ProdutoServico> findAll() {
		return null;
	}

	@Override
	public Iterable<ProdutoServico> findAllById(Iterable<Long> iterable) {
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
	public void delete(ProdutoServico produtoServico) {

	}

	@Override
	public void deleteAll(Iterable<? extends ProdutoServico> iterable) {

	}

	@Override
	public void deleteAll() {

	}

	@Override
	public <S extends ProdutoServico> S save(S s) {
		return null;
	}

	@Override
	public <S extends ProdutoServico> Iterable<S> saveAll(Iterable<S> iterable) {
		return null;
	}

	@Override
	public Optional<ProdutoServico> findById(Long id) {
		return Optional.empty();
	}

	@Override
	public boolean existsById(Long aLong) {
		return false;
	}
}
