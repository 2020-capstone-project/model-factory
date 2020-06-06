package config;

import client.ClientApi;
import jdk.internal.net.http.HttpClientBuilderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import sun.net.www.http.HttpClient;

@Configuration
public class ClientConfig {

  @Bean
  public ClientApi clientApi() {
    return new ClientApi();
  }

}
