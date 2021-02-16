package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelDto {

  private int id;
  private String modelPath;
  private String diagramPath;
  private Timestamp createdDate;
  private int learningId;

  public ModelDto(ResultByInsertLearningDto dto) {
    learningId = dto.getId();
  }

}
