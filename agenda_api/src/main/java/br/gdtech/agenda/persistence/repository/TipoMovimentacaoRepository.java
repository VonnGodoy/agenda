package br.gdtech.agenda.persistence.repository;

import br.gdtech.agenda.model.TipoMovimentacao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TipoMovimentacaoRepository extends CrudRepository<TipoMovimentacao, Long> {

	public List<TipoMovimentacao> findAll();
	public Optional<TipoMovimentacao> findById(Long id);

}
