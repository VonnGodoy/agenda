package br.gdtech.agenda.controller;

import br.gdtech.agenda.enums.*;
import br.gdtech.agenda.util.EnumDecription;
import br.gdtech.agenda.util.EnumUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("enums")
@RequestMapping("/enums")
public class EnumsController {

    @RequestMapping(value = "/perfis", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EnumDecription> perfis() throws Exception { return new EnumUtil().toList(PerfilEnum.class); }
    
    @RequestMapping(value = "/status", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EnumDecription> status() throws Exception { return new EnumUtil().toList(StatusAtendimentoEnum.class); }
    
    @RequestMapping(value = "/tiposContatos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EnumDecription> tiposContatos() throws Exception { return new EnumUtil().toList(TipoContatoEnum.class); }
    
    @RequestMapping(value = "/tiposEnderecos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EnumDecription> tiposEnderecos() throws Exception { return new EnumUtil().toList(TipoEnderecoEnum.class); }
    
    @RequestMapping(value = "/tiposPagamentos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EnumDecription> tiposPagamentos() throws Exception { return new EnumUtil().toList(TipoPagamentoEnum.class); }

}
