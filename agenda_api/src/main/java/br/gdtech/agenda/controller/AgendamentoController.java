package br.gdtech.agenda.controller;

import br.gdtech.agenda.model.Agendamento;
import br.gdtech.agenda.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController("agendamento")
@RequestMapping("/agendamento")
public class AgendamentoController {

	@Autowired
	private AgendamentoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Agendamento> findById(@PathParam("id") Integer id) {
		return service.findById(id);
	}

	@RequestMapping(value = "/filtro", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Agendamento> filtro(@RequestBody Agendamento ag) {
		return service.listar(ag);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Agendamento save(@RequestBody Agendamento ag) {
		return service.save(ag);
	}

	protected void setService(AgendamentoService service) {
		this.service = service;
	}
}
