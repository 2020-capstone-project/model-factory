package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ModelDto {

  private int id;
  private String filepath;
  private Timestamp createdDate;
  private int learningId;

  public ModelDto(ResultByInsertLearningDto dto) {
    learningId = dto.getId();
  }

}
