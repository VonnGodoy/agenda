package br.gdtech.agenda.controller;

import br.gdtech.agenda.model.Pessoa;
import br.gdtech.agenda.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController("pessoa")
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Pessoa> findById(@PathParam("id") Integer id) { return service.findById(id); }

	@RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Pessoa save(@RequestBody Pessoa pessoa) {
		return service.save(pessoa);
	}

	@RequestMapping(value = "/filtro", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Pessoa> findByFiltro(@RequestBody Pessoa pessoa) {
		return service.listar(pessoa);
	}

	public void setPerfil(PessoaService service) {
		this.service = service;
	}

}
