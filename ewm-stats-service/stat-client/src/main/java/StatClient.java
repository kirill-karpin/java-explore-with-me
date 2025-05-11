import java.util.Collections;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class StatClient {

  private final RestTemplate restTemplate;
  private final String baseUrl;
  private final HttpHeaders defaultHeaders;

  public StatClient(String baseUrl) {
    this.restTemplate = new RestTemplate();
    this.baseUrl = baseUrl.endsWith("/") ? baseUrl : baseUrl + "/";

    // Настройка заголовков по умолчанию
    this.defaultHeaders = new HttpHeaders();
    defaultHeaders.setContentType(MediaType.APPLICATION_JSON);
    defaultHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
  }

  // GET запрос
  public <T> T get(String path, Class<T> responseType, Object... uriVariables) {
    String url = buildUrl(path);
    return restTemplate.getForObject(url, responseType, uriVariables);
  }

  // POST запрос
  public <T, R> T post(String path, R requestBody, Class<T> responseType) {
    String url = buildUrl(path);
    HttpEntity<R> entity = new HttpEntity<>(requestBody, defaultHeaders);
    return restTemplate.postForObject(url, entity, responseType);
  }

  // PUT запрос
  public <R> void put(String path, R requestBody, Object... uriVariables) {
    String url = buildUrl(path);
    HttpEntity<R> entity = new HttpEntity<>(requestBody, defaultHeaders);
    restTemplate.put(url, entity, uriVariables);
  }

  // DELETE запрос
  public void delete(String path, Object... uriVariables) {
    String url = buildUrl(path);
    restTemplate.delete(url, uriVariables);
  }

  // Вспомогательный метод для построения полного URL
  private String buildUrl(String path) {
    // Удаляем ведущий слэш, если он есть, чтобы избежать дублирования
    String cleanedPath = path.startsWith("/") ? path.substring(1) : path;
    return baseUrl + cleanedPath;
  }
}
