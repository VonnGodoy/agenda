package br.gdtech.agenda.persistence.impl;

import br.gdtech.agenda.enums.StatusAtendimentoEnum;
import br.gdtech.agenda.model.Agendamento;
import br.gdtech.agenda.persistence.generic.RepositorioBase;
import br.gdtech.agenda.persistence.repository.AgendamentoRepository;
import org.jinq.jpa.JPAJinqStream;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class AgendamentoRepositoryImpl extends RepositorioBase<Agendamento, Long> implements AgendamentoRepository {

	public List<Agendamento> listar(Agendamento filtro) {

		JPAJinqStream<Agendamento> streams = stream(Agendamento.class);

		Long id = filtro.getId() != null ? filtro.getId() : null;
		String doc = filtro.getCliente() != null && !filtro.getCliente().getCpfCnpj().isEmpty()
				? filtro.getCliente().getCpfCnpj()
				: null;
		LocalDate dataInicio = filtro.getDataInicio() != null ? filtro.getDataInicio() : null;
		LocalDate dataFim = filtro.getDataFim() != null ? filtro.getDataFim() : null;
		LocalDate registro = filtro.getRegistro() != null ? filtro.getRegistro() : null;
		StatusAtendimentoEnum status = filtro.getStatus() != null ? filtro.getStatus() : null;

		if (id != null)
			streams = streams.where(a -> a.getId().equals(id));
		if (doc != null)
			streams = streams.where(a -> a.getCliente().getCpfCnpj().equals(doc));
		if (dataInicio != null && dataFim == null)
			streams = streams.where(a -> a.getData().isEqual(dataInicio));
		if (dataInicio != null && dataFim != null)
			streams = streams.where(a -> a.getData().isAfter(dataInicio) && a.getData().isBefore(dataFim));
		if (registro != null)
			streams = streams.where(a -> a.getRegistro().equals(registro));
		if (status != null)
			streams = streams.where(a -> a.getStatus().equals(status));

		return streams.toList();
	}

	@Override
	public List<Agendamento> findAll() {
		return null;
	}

	@Override
	public Iterable<Agendamento> findAllById(Iterable<Long> iterable) {
		return null;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void deleteById(Long aLong) {

	}

	@Override
	public void delete(Agendamento agendamento) {

	}

	@Override
	public void deleteAll(Iterable<? extends Agendamento> iterable) {

	}

	@Override
	public void deleteAll() {

	}

	@Override
	public <S extends Agendamento> S save(S s) {
		return null;
	}

	@Override
	public <S extends Agendamento> Iterable<S> saveAll(Iterable<S> iterable) {
		return null;
	}

	@Override
	public Optional<Agendamento> findById(Long id) {
		return Optional.empty();
	}

	@Override
	public boolean existsById(Long aLong) {
		return false;
	}
}
