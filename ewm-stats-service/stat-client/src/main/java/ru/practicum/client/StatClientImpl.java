package ru.practicum.client;

import dto.HitDto;
import dto.HitValue;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
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

    ResponseEntity<List<HitValue>> response = restClient.get()
        .uri(uriBuilder -> uriBuilder
            .path("/stats")
            .queryParam("start", start)
            .queryParam("end", end)
            .queryParam("uris", uris)
            .queryParam("unique", unique)
            .build())
        .header("Content-Type", "application/json")
        .retrieve()
        .toEntity(new ParameterizedTypeReference<>() {
        });

    return response.getBody();
  }

  @Override
  public void hit(HitDto hitDto) {
    restClient.post()
        .uri("/hit")
        .header("Content-Type", "application/json")
        .body(hitDto)
        .retrieve()
        .toBodilessEntity();
  }
}
