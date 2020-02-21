package br.gdtech.agenda.persistence.impl;

import br.gdtech.agenda.enums.PerfilEnum;
import br.gdtech.agenda.model.Pessoa;
import br.gdtech.agenda.persistence.generic.RepositorioBase;
import br.gdtech.agenda.persistence.repository.PessoaRepository;
import org.jinq.jpa.JPAJinqStream;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PessoaRepositoryImpl extends RepositorioBase<Pessoa, Integer> implements PessoaRepository {

	public List<Pessoa> listar(Pessoa montarFiltros) {
		JPAJinqStream<Pessoa> streams = montarFiltros(montarFiltros);

		return streams.toList();
	}

	public Optional<Pessoa> findById(Integer id) {
		JPAJinqStream<Pessoa> streams = stream(Pessoa.class);
		streams = streams.where(a -> a.getId().equals(id));

		return streams.findOne();
	}

	public boolean existsById(Integer id) {
		JPAJinqStream<Pessoa> streams = stream(Pessoa.class);
		streams = streams.where(a -> a.getId().equals(id));

		return streams.count() > 0 ? true : false;
	}

	public long count(Pessoa filtro) {
		JPAJinqStream<Pessoa> streams = montarFiltros(filtro);

		return streams.count();
	}

	private JPAJinqStream<Pessoa> montarFiltros(Pessoa filtro){
		JPAJinqStream<Pessoa> streams = stream(Pessoa.class);

		Integer id = filtro.getId() != null ? filtro.getId() : null;
		String nome = filtro.getNome() != null ? filtro.getNome() : null;
		String cpfCnpj = filtro.getCpfCnpj() != null ? filtro.getCpfCnpj() : null;
		PerfilEnum perfil = filtro.getPerfil() != null ? filtro.getPerfil() : null;
		Integer mesNascimento = filtro.getMes() != null ? filtro.getMes() : null;

		if (id != null)
			streams = streams.where(a -> a.getId() == id);
		if (nome != null)
			streams = streams.where(a -> a.getNome().contains(nome));
		if (cpfCnpj != null)
			streams = streams.where(a -> a.getCpfCnpj().equals(cpfCnpj));
		if (perfil != null)
			streams = streams.where(a -> a.getPerfil().equals(perfil));
		if (mesNascimento != null)
			streams = streams.where(a -> a.getDtNascimento().getDayOfMonth() == mesNascimento);

		return streams;
	}

	@Override
	public List<Pessoa> findAll() {
		return null;
	}

	@Override
	public Iterable<Pessoa> findAllById(Iterable<Integer> iterable) {
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
	public void delete(Pessoa pessoa) {

	}

	@Override
	public void deleteAll(Iterable<? extends Pessoa> iterable) {

	}

	@Override
	public void deleteAll() {

	}

	@Override
	public <S extends Pessoa> S save(S s) {
		return null;
	}

	@Override
	public <S extends Pessoa> Iterable<S> saveAll(Iterable<S> iterable) {
		return null;
	}
}
