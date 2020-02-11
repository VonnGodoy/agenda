package br.gdtech.agenda.service;

import br.gdtech.agenda.model.Atendimento;
import br.gdtech.agenda.repository.AtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AtendimentoService {

	@Autowired
	private AtendimentoRepository repository;

	public Optional<Atendimento> findById(Integer id) {
		return repository.findById(id);
	}

	public Atendimento save(Atendimento atendimento) {
		return repository.save(atendimento);
	}

	public List<Atendimento> listar(Atendimento at) {
		return repository.listar(at);

	}

	protected void setRepository(AtendimentoRepository repository) {
		this.repository = repository;
	}

}