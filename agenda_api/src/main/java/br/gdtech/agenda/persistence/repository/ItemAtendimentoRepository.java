package br.gdtech.agenda.persistence.repository;

import br.gdtech.agenda.model.ItemAtendimento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemAtendimentoRepository extends CrudRepository<ItemAtendimento, Long> {

	public List<ItemAtendimento> findAll();
	public Optional<ItemAtendimento> findById(Long id);

}