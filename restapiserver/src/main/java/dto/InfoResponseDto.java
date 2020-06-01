package dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class InfoResponseDto {

  private String name;
  private String email;

  public InfoResponseDto(String name, String email) {
    this.name = name;
    this.email = email;
  }

}
