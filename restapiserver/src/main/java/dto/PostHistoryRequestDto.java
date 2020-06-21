package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostHistoryRequestDto {

  private int learningId;
  private int epochCount;
  private double trainLoss;
  private double trainAccuracy;
  private double valLoss;
  private double valAccuracy;

}
