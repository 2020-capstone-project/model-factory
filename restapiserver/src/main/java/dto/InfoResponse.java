package dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class InfoResponse {

  private String name;
  private String email;

  public InfoResponse(String name, String email) {
    this.name = name;
    this.email = email;
  }

}
