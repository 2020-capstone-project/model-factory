package dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class AdjustRequestDto {

  @NotBlank
  private String name;
  @NotBlank
  private String email;
  @NotBlank
  private String currentPassword;
  @NotBlank
  private String newPassword;

}
