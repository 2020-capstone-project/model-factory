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

}
