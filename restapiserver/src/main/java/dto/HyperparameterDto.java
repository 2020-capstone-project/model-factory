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

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("HyperparameterDto{");
    sb.append("epoch=").append(epoch);
    sb.append(", batchSize=").append(batchSize);
    sb.append(", lossFunction='").append(lossFunction).append('\'');
    sb.append(", optimizerFunction='").append(optimizerFunction).append('\'');
    sb.append('}');
    return sb.toString();
  }

}
