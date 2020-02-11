package br.gdtech.agenda.repository;

import br.gdtech.agenda.enums.StatusAtendimentoEnum;
import br.gdtech.agenda.model.Agendamento;
import org.jinq.jpa.JPAJinqStream;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public abstract class AgendamentoRepository extends RepositorioBase<Agendamento> {

	public List<Agendamento> listar(Agendamento filtro) {

		JPAJinqStream<Agendamento> streams = stream();

		Integer id = filtro.getId() != null ? filtro.getId() : null;
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

}
