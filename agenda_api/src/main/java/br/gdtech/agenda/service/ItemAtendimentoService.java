package br.gdtech.agenda.service;

import br.gdtech.agenda.model.ItemAtendimento;
import br.gdtech.agenda.persistence.impl.ItemAtendimentoRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemAtendimentoService {

	@Autowired
	private ItemAtendimentoRepositoryImpl repository;

	public Optional<ItemAtendimento> findById(Integer id) {
		return repository.findById(id);
	}

	public ItemAtendimento save(ItemAtendimento item) {
		return repository.save(item);
	}

	public void delete(ItemAtendimento item) {
		repository.delete(item);
	}

	public List<ItemAtendimento> listar(ItemAtendimento item) {
		return repository.listar(item);
	}

	protected void setRepository(ItemAtendimentoRepositoryImpl repository) {
		this.repository = repository;
	}

}
