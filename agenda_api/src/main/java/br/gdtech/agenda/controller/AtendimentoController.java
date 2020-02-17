package br.gdtech.agenda.controller;

import br.gdtech.agenda.model.Atendimento;
import br.gdtech.agenda.service.AtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController("atendimento")
@RequestMapping("/atendimento")
public class AtendimentoController {

	@Autowired
	private AtendimentoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Atendimento>  findById(@PathParam("id") Long id) {
		return service.findById(id);
	}

	@RequestMapping(value = "/filtro", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Atendimento> filtro(@RequestBody Atendimento at) {
		return service.listar(at);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Atendimento save(@RequestBody Atendimento atendimento) {
		return service.save(atendimento);
	}

	protected void setService(AtendimentoService service) {
		this.service = service;
	}

}