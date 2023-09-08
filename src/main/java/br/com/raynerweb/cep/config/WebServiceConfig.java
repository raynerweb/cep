package br.com.raynerweb.cep.config;

import br.com.raynerweb.cep.ws.CorreiosWS;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WebServiceConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("br.com.correios");
        return marshaller;
    }

    @Bean
    public CorreiosWS correiosWS(Jaxb2Marshaller marshaller) {
        CorreiosWS client = new CorreiosWS();
        client.setDefaultUri("https://apps.correios.com.br/SigepMasterJPA/AtendeClienteService/AtendeCliente");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
