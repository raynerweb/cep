package br.com.raynerweb.cep.rest;

import br.com.correios.EnderecoERP;
import br.com.raynerweb.cep.ws.CorreiosWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CepRest {

    @Autowired
    private CorreiosWS ws;

    @GetMapping("{cep}")
    public EnderecoERP findByCep(@PathVariable String cep) {
        return ws.getEndereco(cep);
    }

}
