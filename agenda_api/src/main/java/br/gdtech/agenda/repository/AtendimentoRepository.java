package br.gdtech.agenda.repository;

import br.gdtech.agenda.enums.StatusAtendimentoEnum;
import br.gdtech.agenda.enums.TipoPagamentoEnum;
import br.gdtech.agenda.model.Atendimento;
import org.jinq.jpa.JPAJinqStream;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public abstract class AtendimentoRepository extends RepositorioBase<Atendimento> {

	public List<Atendimento> listar(Atendimento filtro) {

		JPAJinqStream<Atendimento> streams = stream();

		Integer id = filtro.getId() != null ? filtro.getId() : null;
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

	public Atendimento gravar(Atendimento at) {
		return this.save(at);
	}

	public Optional<Atendimento> buscarPorId(Integer id) {
		return this.findById(id);
	}
}
