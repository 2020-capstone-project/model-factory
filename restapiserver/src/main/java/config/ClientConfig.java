package config;

import client.ClientApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {

  @Bean
  public ClientApi clientApi() {
    return new ClientApi();
  }

}
