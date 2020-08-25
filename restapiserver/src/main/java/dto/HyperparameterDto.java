package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HyperparameterDto {

  private int epoch;
  private int batchSize;
  private String lossFunction;
  private String optimizerFunction;

}
