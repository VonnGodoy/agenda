package br.gdtech.agenda.service;

import br.gdtech.agenda.model.TipoMovimentacao;
import br.gdtech.agenda.repository.TipoMovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TipoMovimentacaoService {

	@Autowired
	private TipoMovimentacaoRepository repository;

	public Optional<TipoMovimentacao> findById(Integer id) {
		return repository.findById(id);
	}

	public TipoMovimentacao save(TipoMovimentacao mov) {
		return repository.save(mov);
	}

	public List<TipoMovimentacao> listar(TipoMovimentacao tipo) {
		return repository.listar(tipo);
	}

	protected void setRepository(TipoMovimentacaoRepository repository) {
		this.repository = repository;
	}
}
