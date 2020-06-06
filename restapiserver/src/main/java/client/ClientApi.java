package client;

import dto.PostLearningToFlaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class ClientApi {

  public void postLearningToFlask(PostLearningToFlaskDto dto) {
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.postForObject("http://127.0.0.1:5000/learning", dto, PostLearningToFlaskDto.class);
  }

}
