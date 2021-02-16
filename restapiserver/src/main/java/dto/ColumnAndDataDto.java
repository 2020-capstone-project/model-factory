package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ColumnAndDataDto {

  private int id;
  private String name;
  private String description;
  private int fileId;
  private List<String> value;

}
