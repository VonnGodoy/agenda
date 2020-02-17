package br.gdtech.agenda.service;

import br.gdtech.agenda.model.Pessoa;
import br.gdtech.agenda.persistence.impl.PessoaRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PessoaService {

	@Autowired
	private PessoaRepositoryImpl repository;

	public Optional<Pessoa> findById(Long id) {
		id = 1l;
		return repository.findById(id);
	}
	
	public Pessoa save(Pessoa pes) {
		return repository.save(pes);
	}

	public List<Pessoa> listar(Pessoa pes) {
		return repository.listar(pes);
	}

	protected void setRepository(PessoaRepositoryImpl repository) {
		this.repository = repository;
	}
}
