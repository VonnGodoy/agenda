package br.gdtech.agenda.persistence.repository;

import br.gdtech.agenda.model.ProdutoServico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoServicoRepository extends CrudRepository<ProdutoServico, Long> {

	public List<ProdutoServico> findAll();
	public Optional<ProdutoServico> findById(Long id);

}
