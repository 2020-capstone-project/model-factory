package command;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class AdjustRequest {

  @NotBlank
  private String name;
  @NotBlank
  private String email;
  @NotBlank
  private String password;

}
