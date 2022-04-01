package com.springframe.springframe.api.implementation;

import com.springframe.springframe.model.dto.AuxilioEmergencialDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotNull;
import java.util.List;

public class ApiWebClient {
    private final WebClient localApiClient;

    public ApiWebClient(@NotNull WebClient.Builder webClientBuilder){
        this.localApiClient = webClientBuilder.build();
    }

    public List<AuxilioEmergencialDTO> callApi(){
        Mono<List<AuxilioEmergencialDTO>> response = localApiClient
                .get()
                .uri("https://api.portaldatransparencia.gov.br/api-de-dados/auxilio-emergencial-beneficiario-por-municipio")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<AuxilioEmergencialDTO>>() {
                });

        return response.block();
    }

}
