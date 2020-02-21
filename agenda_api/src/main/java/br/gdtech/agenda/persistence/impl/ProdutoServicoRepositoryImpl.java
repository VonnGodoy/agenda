package br.gdtech.agenda.persistence.impl;

import br.gdtech.agenda.model.ProdutoServico;
import br.gdtech.agenda.persistence.generic.RepositorioBase;
import br.gdtech.agenda.persistence.repository.ProdutoServicoRepository;
import org.jinq.jpa.JPAJinqStream;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProdutoServicoRepositoryImpl extends RepositorioBase<ProdutoServico, Integer> implements ProdutoServicoRepository {


	public List<ProdutoServico> listar(ProdutoServico montarFiltros) {
		JPAJinqStream<ProdutoServico> streams = montarFiltros(montarFiltros);

		return streams.toList();
	}

	public Optional<ProdutoServico> findById(Integer id) {
		JPAJinqStream<ProdutoServico> streams = stream(ProdutoServico.class);
		streams = streams.where(a -> a.getId().equals(id));

		return streams.findOne();
	}

	public boolean existsById(Integer id) {
		JPAJinqStream<ProdutoServico> streams = stream(ProdutoServico.class);
		streams = streams.where(a -> a.getId().equals(id));

		return streams.count() > 0 ? true : false;
	}

	public long count(ProdutoServico filtro) {
		JPAJinqStream<ProdutoServico> streams = montarFiltros(filtro);

		return streams.count();
	}


	private JPAJinqStream<ProdutoServico> montarFiltros(ProdutoServico filtro){
		JPAJinqStream<ProdutoServico> streams = stream(ProdutoServico.class);

		Integer id = filtro.getId() != null ? filtro.getId() : null;
		String nome = filtro.getServico() != null ? filtro.getServico() : null;
		Boolean ativo = filtro.getAtivo() != null ? filtro.getAtivo() : null;

		if (id != null)
			streams = streams.where(a -> a.getId() == id);
		if (nome != null)
			streams = streams.where(a -> a.getServico().contains(nome));
		if (ativo != null)
			streams = streams.where(a -> a.getAtivo().equals(ativo));

		return streams;
	}

	@Override
	public List<ProdutoServico> findAll() {
		return null;
	}

	@Override
	public Iterable<ProdutoServico> findAllById(Iterable<Integer> iterable) {
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
}
