package br.gdtech.agenda.persistence.repository;

import br.gdtech.agenda.model.Agendamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AgendamentoRepository extends CrudRepository<Agendamento, Long> {

	public List<Agendamento> findAll();
	public Optional<Agendamento> findById(Long id);

}
