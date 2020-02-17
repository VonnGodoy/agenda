package br.gdtech.agenda.persistence.impl;

import br.gdtech.agenda.enums.StatusAtendimentoEnum;
import br.gdtech.agenda.enums.TipoPagamentoEnum;
import br.gdtech.agenda.model.Atendimento;
import br.gdtech.agenda.persistence.generic.RepositorioBase;
import br.gdtech.agenda.persistence.repository.AtendimentoRepository;
import org.jinq.jpa.JPAJinqStream;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class AtendimentoRepositoryImpl extends RepositorioBase<Atendimento, Long> implements AtendimentoRepository {

	public List<Atendimento> listar(Atendimento filtro) {

		JPAJinqStream<Atendimento> streams = stream(Atendimento.class);

		Long id = filtro.getId() != null ? filtro.getId() : null;
		String doc = filtro.getAgendamento().getCliente() != null
				&& !filtro.getAgendamento().getCliente().getCpfCnpj().isEmpty()
						? filtro.getAgendamento().getCliente().getCpfCnpj()
						: null;
		LocalDate dataInicio = filtro.getDataInicio() != null ? filtro.getDataInicio() : null;
		LocalDate dataFim = filtro.getDataFim() != null ? filtro.getDataFim() : null;
		TipoPagamentoEnum tipoPagamento = filtro.getTpPagamento() != null ? filtro.getTpPagamento() : null;
		StatusAtendimentoEnum status = filtro.getStatus() != null ? filtro.getStatus() : null;

		if (id != null)
			streams = streams.where(a -> a.getId().equals(id));
		if (doc != null)
			streams = streams.where(a -> a.getAgendamento().getCliente().getCpfCnpj().equals(doc));
		if (dataInicio != null && dataFim == null)
			streams = streams.where(a -> a.getData().isEqual(dataInicio));
		if (dataInicio != null && dataFim != null)
			streams = streams.where(a -> a.getData().isAfter(dataInicio) && a.getData().isBefore(dataFim));
		if (tipoPagamento != null)
			streams = streams.where(a -> a.getTpPagamento().equals(tipoPagamento));
		if (status != null)
			streams = streams.where(a -> a.getStatus().equals(status));

		return streams.toList();
	}

	@Override
	public List<Atendimento> findAll() {
		return null;
	}

	@Override
	public Iterable<Atendimento> findAllById(Iterable<Long> iterable) {
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
	public void delete(Atendimento atendimento) {

	}

	@Override
	public void deleteAll(Iterable<? extends Atendimento> iterable) {

	}

	@Override
	public void deleteAll() {

	}

	@Override
	public <S extends Atendimento> S save(S s) {
		return null;
	}

	@Override
	public <S extends Atendimento> Iterable<S> saveAll(Iterable<S> iterable) {
		return null;
	}

	@Override
	public Optional<Atendimento> findById(Long id) {
		return Optional.empty();
	}

	@Override
	public boolean existsById(Long aLong) {
		return false;
	}
}
