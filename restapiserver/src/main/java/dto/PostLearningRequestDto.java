package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostLearningRequestDto {

  @Min(1)
  private int fileId;
  @NotBlank
  private String prediction;
  @Size(min = 1)
  private List<String> inputColumns;
  @Size(min = 1)
  private List<String> outputColumns;
  @Min(1)
  private int batchSize;
  @Min(1)
  private int epoch;
  @NotBlank
  private String lossFunction;
  @NotBlank
  private String optimizerFunction;
  @Min(1)
  private int memberId;
  @Size(min = 1)
  private List<LayerDto> layers;

}
