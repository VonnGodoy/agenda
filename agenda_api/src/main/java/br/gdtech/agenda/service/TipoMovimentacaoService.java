package br.gdtech.agenda.service;

import br.gdtech.agenda.model.TipoMovimentacao;
import br.gdtech.agenda.persistence.impl.TipoMovimentacaoRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TipoMovimentacaoService {

	@Autowired
	private TipoMovimentacaoRepositoryImpl repository;

	public Optional<TipoMovimentacao> findById(Long id) {
		return repository.findById(id);
	}

	public TipoMovimentacao save(TipoMovimentacao mov) {
		return repository.save(mov);
	}

	public List<TipoMovimentacao> listar(TipoMovimentacao tipo) {
		return repository.listar(tipo);
	}

	protected void setRepository(TipoMovimentacaoRepositoryImpl repository) {
		this.repository = repository;
	}
}
