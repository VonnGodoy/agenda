package br.gdtech.agenda.controller;

import br.gdtech.agenda.model.ItemAtendimento;
import br.gdtech.agenda.service.ItemAtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController("itemAtendimento")
@RequestMapping("/itemAtendimento")
public class ItemAtendimentoController {

	@Autowired
	private ItemAtendimentoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<ItemAtendimento> findById(@PathParam("id") Integer id) {
		return service.findById(id);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ItemAtendimento save(@RequestBody ItemAtendimento item) {
		return service.save(item);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@RequestBody ItemAtendimento item) {
		service.delete(item);
	}

	@RequestMapping(value = "/filtro", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ItemAtendimento> findByfiltro(@RequestBody ItemAtendimento item) {
		return service.listar(item);
	}

}
