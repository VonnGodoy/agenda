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
public class AgendamentoRepositoryImpl extends RepositorioBase<Agendamento, Integer> implements AgendamentoRepository {

	public List<Agendamento> listar(Agendamento filtro) {
		JPAJinqStream<Agendamento> streams = montarFiltros(filtro);

		return streams.toList();
	}

	public Optional<Agendamento> findById(Integer id) {
		JPAJinqStream<Agendamento> streams = stream(Agendamento.class);
		streams = streams.where(a -> a.getId().equals(id));

		return streams.findOne();
	}

	public boolean existsById(Integer id) {
		JPAJinqStream<Agendamento> streams = stream(Agendamento.class);
		streams = streams.where(a -> a.getId().equals(id));

		return streams.count() > 0 ? true : false;
	}

	public long count(Agendamento filtro) {
		JPAJinqStream<Agendamento> streams = montarFiltros(filtro);

		return streams.count();
	}

	private JPAJinqStream<Agendamento> montarFiltros(Agendamento filtro){
		JPAJinqStream<Agendamento> streams = stream(Agendamento.class);

		Integer id = filtro.getId() != null ? filtro.getId() : null;
		String doc = filtro.getCliente() != null && !filtro.getCliente().getCpfCnpj().isEmpty()
				? filtro.getCliente().getCpfCnpj()
				: null;
		LocalDate dataInicio = filtro.getDataInicio() != null ? filtro.getDataInicio() : null;
		LocalDate dataFim = filtro.getDataFim() != null ? filtro.getDataFim() : null;
		StatusAtendimentoEnum status = filtro.getStatus() != null ? filtro.getStatus() : null;

		if (id != null)
			streams = streams.where(a -> a.getId() == id);
		if (doc != null)
			streams = streams.where(a -> a.getCliente().getCpfCnpj().equals(doc));
		if (dataInicio != null && dataFim == null)
			streams = streams.where(a -> a.getData().isEqual(dataInicio));
		if (dataInicio != null && dataFim != null)
			streams = streams.where(a -> a.getData().isAfter(dataInicio) && a.getData().isBefore(dataFim));
		if (status != null)
			streams = streams.where(a -> a.getStatus().equals(status));

		return streams;
	}

	@Override
	public List<Agendamento> findAll() {
		return null;
	}

	@Override
	public Iterable<Agendamento> findAllById(Iterable<Integer> iterable) {
		return null;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void deleteById(Integer integer) {

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

}
