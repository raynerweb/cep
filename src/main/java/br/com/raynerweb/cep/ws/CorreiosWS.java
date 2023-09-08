package br.com.raynerweb.cep.ws;

import br.com.correios.ConsultaCEP;
import br.com.correios.ConsultaCEPResponse;
import br.com.correios.EnderecoERP;
import br.com.correios.ObjectFactory;
import jakarta.xml.bind.JAXBElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class CorreiosWS extends WebServiceGatewaySupport {
    private static final Logger LOG = LoggerFactory.getLogger(CorreiosWS.class);

    public EnderecoERP getEndereco(String cep) {
        LOG.warn("Consumindo webservice dos correios para o cep: " + cep);
        ConsultaCEP consultaCep = new ConsultaCEP();
        consultaCep.setCep(cep);
        JAXBElement<ConsultaCEP> request = new ObjectFactory().createConsultaCEP(consultaCep);
        Object o = getWebServiceTemplate().marshalSendAndReceive(request);
        JAXBElement<ConsultaCEPResponse> result = (JAXBElement<ConsultaCEPResponse>) o;
        ConsultaCEPResponse response = result.getValue();
        return response.getReturn();
    }

}
