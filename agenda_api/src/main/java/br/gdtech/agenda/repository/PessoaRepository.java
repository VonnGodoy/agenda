package br.gdtech.agenda.repository;

import br.gdtech.agenda.enums.PerfilEnum;
import br.gdtech.agenda.model.Pessoa;
import org.jinq.jpa.JPAJinqStream;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public abstract class PessoaRepository extends RepositorioBase<Pessoa> {

	public List<Pessoa> listar(Pessoa filtro) {

		JPAJinqStream<Pessoa> streams = stream();

		Integer id = filtro.getId() != null ? filtro.getId() : null;
		String nome = filtro.getNome() != null ? filtro.getNome() : null;
		String cpfCnpj = filtro.getCpfCnpj() != null ? filtro.getCpfCnpj() : null;
		PerfilEnum perfil = filtro.getPerfil() != null ? filtro.getPerfil() : null;
		Integer mesNascimento = filtro.getMes() != null ? filtro.getMes() : null;

		if (id != null)
			streams = streams.where(a -> a.getId() == id);
		if (nome != null)
			streams = streams.where(a -> a.getNome().equals(nome));
		if (cpfCnpj != null)
			streams = streams.where(a -> a.getCpfCnpj().equals(cpfCnpj));
		if (perfil != null)
			streams = streams.where(a -> a.getPerfil().equals(perfil));
		if (mesNascimento != null)
			streams = streams.where(a -> a.getDtNascimento().getDayOfMonth() == mesNascimento);

		return streams.toList();
	}

	public Pessoa gravar(Pessoa ag) {
		return this.save(ag);
	}

	public Optional<Pessoa> buscarPorId(Integer id) {
		return this.findById(id);
	}
}
