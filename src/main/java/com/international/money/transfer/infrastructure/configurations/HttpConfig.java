package com.international.money.transfer.infrastructure.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpConfig {

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
