package ru.practicum.ewmmainservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import ru.practicum.client.StatClient;
import ru.practicum.client.StatClientImpl;

@org.springframework.context.annotation.Configuration
public class StatClientConfig {
    @Bean
    public StatClient statClient(@Value("${app.client.url}") String statServerUrl) {
        return new StatClientImpl(statServerUrl);
    }
}
