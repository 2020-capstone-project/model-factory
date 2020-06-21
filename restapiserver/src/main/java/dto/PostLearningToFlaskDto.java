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
public class PostLearningToFlaskDto {

  private int learningId;
  private String learningFilePath;
  private String modelPath;
  private String diagramPath;
  private String prediction;
  private List<String> inputColumns;
  private List<String> outputColumns;
  private int batchSize;
  private int epoch;
  private String lossFunction;
  private String optimizerFunction;
  private List<LayerDto> layers;

  public PostLearningToFlaskDto(String learningFilePath, ModelDto modelDto, PostLearningRequestDto dto) {
    this.learningId = modelDto.getLearningId();
    this.learningFilePath = learningFilePath;
    modelPath = modelDto.getModelPath();
    diagramPath = modelDto.getDiagramPath();
    prediction = dto.getPrediction();
    inputColumns = dto.getInputColumns();
    outputColumns = dto.getOutputColumns();
    batchSize = dto.getBatchSize();
    epoch = dto.getEpoch();
    lossFunction = dto.getLossFunction();
    optimizerFunction = dto.getOptimizerFunction();
    layers = dto.getLayers();
  }

}
