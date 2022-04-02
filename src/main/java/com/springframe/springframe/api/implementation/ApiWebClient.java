package com.springframe.springframe.api.implementation;

import com.springframe.springframe.api.interfaces.iApiExterna;
import com.springframe.springframe.model.dto.AuxilioEmergencialDTO;
import com.springframe.springframe.model.form.AuxilioEmergencialForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class ApiWebClient implements iApiExterna {

    private final WebClient localApiClient;

    public ApiWebClient(@NotNull WebClient.Builder webClientBuilder) {
        this.localApiClient = webClientBuilder.build();
    }

    public List<AuxilioEmergencialForm> callApi(String anoMes, String codigoIBGE){
        Mono<List<AuxilioEmergencialForm>> response = localApiClient
                .get()
                .uri("https://api.portaldatransparencia.gov.br/api-de-dados/auxilio-emergencial-beneficiario-por-municipio?codigoIbge=4307005&mesAno=202102&pagina=1")
                .header("chave-api-dados", "6631067809ec42c4a5a3ba0274bb750d")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<AuxilioEmergencialForm>>() {
                });

        return response.block();
    }

}
