package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetLearningStatusResponseDto {

  private List<Double> trainLoss;
  private List<Double> trainAccuracy;
  private List<Double> validationLoss;
  private List<Double> validationAccuracy;
  private int epoch;
  private int batchSize;
  private String lossFunction;

  public GetLearningStatusResponseDto(List<HistoryDto> historyList,
                                      HyperparameterDto hyperparameterDto) {
    trainLoss = new ArrayList<>();
    trainAccuracy = new ArrayList<>();
    validationLoss = new ArrayList<>();
    validationAccuracy = new ArrayList<>();
    historyList.forEach(history -> {
      trainLoss.add(history.getTrainLoss());
      trainAccuracy.add(history.getTrainAccuracy());
      validationLoss.add(history.getValidationLoss());
      validationAccuracy.add(history.getValidationAccuracy());
    });
    epoch = hyperparameterDto.getEpoch();
    batchSize = hyperparameterDto.getBatchSize();
    lossFunction = hyperparameterDto.getLossFunction();
  }

}
