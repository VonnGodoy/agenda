package br.gdtech.agenda.persistence.repository;

import br.gdtech.agenda.model.Movimentacao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovimentacaoRepository extends CrudRepository<Movimentacao, Long> {

	public List<Movimentacao> findAll();
	public Optional<Movimentacao> findById(Long id);

}