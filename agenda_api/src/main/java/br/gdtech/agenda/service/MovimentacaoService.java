package br.gdtech.agenda.service;

import br.gdtech.agenda.model.Movimentacao;
import br.gdtech.agenda.persistence.impl.MovimentacaoRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MovimentacaoService {

	@Autowired
	private MovimentacaoRepositoryImpl repository;

	public Optional<Movimentacao> findById(Integer id) {
		return repository.findById(id);
	}

	public Movimentacao save(Movimentacao movimentacao) {
		return repository.save(movimentacao);
	}

	public List<Movimentacao> listar(Movimentacao mov) { return repository.listar(mov); }

	protected void setRepository(MovimentacaoRepositoryImpl repository) {
		this.repository = repository;
	}
}
