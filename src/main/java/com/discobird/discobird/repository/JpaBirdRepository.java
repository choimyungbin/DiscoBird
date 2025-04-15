package com.discobird.discobird.repository;

import com.discobird.discobird.EbirdApiConfig;
import com.discobird.discobird.domain.Bird;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaBirdRepository implements BirdRepository {
    private final RestTemplate restTemplate;
    private final EbirdApiConfig config;

    public JpaBirdRepository(RestTemplate restTemplate, EbirdApiConfig config) {
        this.restTemplate = restTemplate;
        this.config = config;
    }

    @Override
    public List<Bird> findAll() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-eBirdApiToken", config.getApiToken());
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<List<Bird>> response = restTemplate.exchange(
                config.getApiUrl(),
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<Bird>>() {}
        );
        return response.getBody();
    }

    @Override
    public Optional<Bird> findBySpeciesCode(String speciesCode) {
        String url = UriComponentsBuilder.fromHttpUrl(config.getApiUrl())
                .queryParam("species", speciesCode)
                .build()
                .toUriString();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-eBirdApiToken", config.getApiToken());
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<List<Bird>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<Bird>>() {}
        );
        return response.getBody().stream().findAny();
    }

}