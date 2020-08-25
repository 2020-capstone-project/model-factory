package dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberDto {

  private int id;
  private String name;
  private String email;
  private String password;

  public boolean matchPassword(String password) {
    return this.password.equals(password);
  }

}
