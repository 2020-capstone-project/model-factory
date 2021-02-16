package dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.postgresql.util.PGobject;

import javax.validation.constraints.NotBlank;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LearningDto {

  private int id;
  @NotBlank
  private String name;
  @NotBlank
  private int batchSize;
  @NotBlank
  private int epoch;
  @NotBlank
  private String lossFunction;
  @NotBlank
  private String optimizerFunction;
  @NotBlank
  private Timestamp learningDate;
  @NotBlank
  private int memberId;

  public LearningDto(PostLearningRequestDto dto) {
    name = dto.getName();
    batchSize = dto.getBatchSize();
    epoch = dto.getEpoch();
    lossFunction = dto.getLossFunction();
    optimizerFunction = dto.getOptimizerFunction();
    memberId = dto.getMemberId();
  }

}
