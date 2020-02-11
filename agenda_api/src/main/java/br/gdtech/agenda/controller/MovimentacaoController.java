package br.gdtech.agenda.controller;

import br.gdtech.agenda.model.Movimentacao;
import br.gdtech.agenda.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

public class MovimentacaoController {

	@Autowired
	private MovimentacaoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Movimentacao> findById(@PathParam("id") Integer id) {
		return service.findById(id) ;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Movimentacao save(@RequestBody Movimentacao movimentacao) {
		return service.save(movimentacao);
	}

	@RequestMapping(value = "/filtro", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Movimentacao> filtro(@RequestBody Movimentacao mov) {
		return service.listar(mov);

	}

}
