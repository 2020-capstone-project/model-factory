package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LayerDto {

  private int id;
  private int number;
  private String activationFunction;
  private int neuronCount;
  private int learningId;

}
