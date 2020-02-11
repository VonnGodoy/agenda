package br.gdtech.agenda.controller;

import br.gdtech.agenda.model.ProdutoServico;
import br.gdtech.agenda.service.ProdutoServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController("produtoServico")
@RequestMapping("/produtoServico")
public class ProdutoServicoController {

	@Autowired
	private ProdutoServicoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<ProdutoServico> findById(@PathParam("id") Integer id) {
		return service.findById(id);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProdutoServico save(@RequestBody ProdutoServico produto) {
		return service.save(produto);
	}

	@RequestMapping(value = "/filtro", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProdutoServico> findByFiltro(@RequestBody ProdutoServico produto) {
		return service.listar(produto);
	}

	public void setPerfil(ProdutoServicoService service) {
		this.service = service;
	}

}
