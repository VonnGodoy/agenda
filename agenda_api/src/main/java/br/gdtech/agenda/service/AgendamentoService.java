package br.gdtech.agenda.service;

import br.gdtech.agenda.model.Agendamento;
import br.gdtech.agenda.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository repository;

	public Optional<Agendamento> findById(Integer id) {
		return repository.findById(id);
	}

	public Agendamento save(Agendamento agenda) {
		return repository.save(agenda);
	}

	public List<Agendamento> listar(Agendamento at) {
		return repository.listar(at);

	}

	protected void setRepository(AgendamentoRepository repository) {
		this.repository = repository;
	}

}