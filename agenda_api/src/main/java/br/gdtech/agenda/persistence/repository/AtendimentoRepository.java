package br.gdtech.agenda.persistence.repository;

import br.gdtech.agenda.model.Atendimento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AtendimentoRepository extends CrudRepository<Atendimento, Integer> {

	public List<Atendimento> findAll();
	public Optional<Atendimento> findById(Integer id);

}
