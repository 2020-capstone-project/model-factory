package client;

import dto.PostLearningToFlaskDto;
import dto.PostTestResponseByFlask;
import dto.PostTestToFlaskDto;
import org.springframework.web.client.RestTemplate;

public class ClientApi {

  private final String LEARNING_SERVER_URL = "http://127.0.0.1:5000";

  public void postLearningToFlask(PostLearningToFlaskDto dto) {
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.postForObject(LEARNING_SERVER_URL + "/learning", dto, PostLearningToFlaskDto.class);
  }

  public PostTestResponseByFlask postTestToFlask(PostTestToFlaskDto dto) {
    RestTemplate restTemplate = new RestTemplate();
    return restTemplate.postForObject(LEARNING_SERVER_URL + "/test", dto, PostTestResponseByFlask.class);
  }

}
