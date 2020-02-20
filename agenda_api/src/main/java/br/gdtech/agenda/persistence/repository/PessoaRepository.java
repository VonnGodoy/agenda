package br.gdtech.agenda.persistence.repository;

import br.gdtech.agenda.model.Pessoa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Integer> {

	public List<Pessoa> findAll();
	public Optional<Pessoa> findById(Integer id);
}
