package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileUploadDto {

  private int id;
  private String name;
  private String path;
  private String description;
  private int memberId;
  private boolean isPublic;

}
