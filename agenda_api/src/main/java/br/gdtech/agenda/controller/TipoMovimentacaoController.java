package br.gdtech.agenda.controller;

import br.gdtech.agenda.model.TipoMovimentacao;
import br.gdtech.agenda.service.TipoMovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController("tipoMovimentacao")
@RequestMapping("/tipoMovimentacao")
public class TipoMovimentacaoController {

    @Autowired
    private TipoMovimentacaoService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<TipoMovimentacao>  findById(@PathParam("id") Integer id) {
		return service.findById(id);
    }
    
	@RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public TipoMovimentacao save(@RequestBody TipoMovimentacao item) {
		return service.save(item);
	}

    @RequestMapping(value = "/filtro", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TipoMovimentacao> findByFiltro(@RequestBody TipoMovimentacao mov) {
        return service.listar(mov);
    }

    public void setPerfil(TipoMovimentacaoService service) {
        this.service = service;
    }

}
