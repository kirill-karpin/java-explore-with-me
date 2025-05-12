package ru.practicum.client;

import dto.HitValue;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;


public class StatClientImpl implements StatClient {

  private final RestClient restClient;

  public StatClientImpl(String baseUrl) {
    restClient = RestClient.builder()
        .baseUrl(baseUrl)
        .build();
  }

  public List<HitValue> getStatsList(LocalDateTime start, LocalDateTime end, List<String> uris,
      Boolean unique) {

    ResponseEntity<List> response = restClient.get()
        .uri(uriBuilder -> uriBuilder
            .path("/stat")
            .queryParam("start", start)
            .queryParam("end", end)
            .queryParam("uris", uris)
            .queryParam("unique", unique)
            .build())
        .header("Content-Type", "application/json")
        .retrieve()
        .toEntity(List.class);

    return response.getBody();
  }

}
