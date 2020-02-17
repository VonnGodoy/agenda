package br.gdtech.agenda.service;

import br.gdtech.agenda.model.ProdutoServico;
import br.gdtech.agenda.persistence.impl.ProdutoServicoRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProdutoServicoService {

	@Autowired
	private ProdutoServicoRepositoryImpl repository;

	public Optional<ProdutoServico> findById(Long id) {
		return repository.findById(id);
	}
	
	public ProdutoServico save(ProdutoServico pds) {
		return repository.save(pds);
	}

	public List<ProdutoServico> listar(ProdutoServico pds) {
		return repository.listar(pds);
	}

	protected void setRepository(ProdutoServicoRepositoryImpl repository) {
		this.repository = repository;
	}
}
