package dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HyperparameterDto {

  private int epoch;
  private int batchSize;
  private String lossFunction;
  private String optimizerFunction;
  private List<String> inputColumns;
  private List<String> outputColumns;

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("HyperparameterDto{");
    sb.append("epoch=").append(epoch);
    sb.append(", batchSize=").append(batchSize);
    sb.append(", lossFunction='").append(lossFunction).append('\'');
    sb.append(", optimizerFunction='").append(optimizerFunction).append('\'');
    sb.append(", inputColumns=").append(inputColumns);
    sb.append(", outputColumns=").append(outputColumns);
    sb.append('}');
    return sb.toString();
  }

  public void setEpoch(int epoch) {
    this.epoch = epoch;
  }

  public void setBatchSize(int batchSize) {
    this.batchSize = batchSize;
  }

  public void setLossFunction(String lossFunction) {
    this.lossFunction = lossFunction;
  }

  public void setOptimizerFunction(String optimizerFunction) {
    this.optimizerFunction = optimizerFunction;
  }

  public void setInputColumns(String inputColumns) throws JsonProcessingException {
    this.inputColumns = new ObjectMapper().readValue(inputColumns, List.class);
  }

  public void setOutputColumns(String outputColumns) throws JsonProcessingException {
    this.outputColumns = new ObjectMapper().readValue(outputColumns, List.class);
  }

}
