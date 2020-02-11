package br.gdtech.agenda.repository;

import br.gdtech.agenda.enums.TipoPagamentoEnum;
import br.gdtech.agenda.model.Movimentacao;
import org.jinq.jpa.JPAJinqStream;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public abstract class MovimentacaoRepository extends RepositorioBase<Movimentacao> {

	public List<Movimentacao> listar(Movimentacao filtro) {

		JPAJinqStream<Movimentacao> streams = stream();

		Integer id = filtro.getId() != null ? filtro.getId() : null;
		Integer tpMovimentoId = filtro.getTpMovimento() != null ? filtro.getTpMovimento().getId() : null;
		TipoPagamentoEnum tpPagamento = filtro.getTpPagamento() != null ? filtro.getTpPagamento() : null;
		Integer usuarioId = filtro.getUsuario() != null ? filtro.getUsuario().getId() : null;
		LocalDate dataInicio = filtro.getDataInicio() != null ? filtro.getDataInicio() : null;
		LocalDate dataFim = filtro.getDataFim() != null ? filtro.getDataFim() : null;

		if (id != null)
			streams = streams.where(a -> a.getId().equals(id));
		if (tpMovimentoId != null)
			streams = streams.where(a -> a.getTpMovimento().getId().equals(tpMovimentoId));
		if (tpPagamento != null)
			streams = streams.where(a -> a.getTpPagamento().equals(tpPagamento));
		if (usuarioId != null)
			streams = streams.where(a -> a.getUsuario().getId().equals(usuarioId));
		if (dataInicio != null && dataFim == null)
			streams = streams.where(a -> a.getData().isEqual(dataInicio));
		if (dataInicio != null && dataFim != null)
			streams = streams.where(a -> a.getData().isAfter(dataInicio) && a.getData().isBefore(dataFim));

		return streams.toList();
	}

	public Movimentacao gravar(Movimentacao ag) {
		return this.save(ag);
	}

	public Optional<Movimentacao> buscarPorId(Integer id) {
		return this.findById(id);
	}

}