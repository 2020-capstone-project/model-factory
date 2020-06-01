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

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Member{");
    sb.append("id=").append(id);
    sb.append(", name='").append(name).append('\'');
    sb.append(", email='").append(email).append('\'');
    sb.append(", password='").append(password).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
