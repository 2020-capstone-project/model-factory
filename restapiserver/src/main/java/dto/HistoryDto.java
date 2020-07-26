package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoryDto {

  private double trainLoss;
  private double trainAccuracy;
  private double validationLoss;
  private double validationAccuracy;

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("HistoryDto{");
    sb.append("trainLoss=").append(trainLoss);
    sb.append(", trainAccuracy=").append(trainAccuracy);
    sb.append(", validationLoss=").append(validationLoss);
    sb.append(", validationAccuracy=").append(validationAccuracy);
    sb.append('}');
    return sb.toString();
  }
}
