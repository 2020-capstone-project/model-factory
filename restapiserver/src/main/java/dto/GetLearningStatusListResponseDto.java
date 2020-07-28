package dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class  GetLearningStatusListResponseDto {

  private int id;
  private String name;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
  private Timestamp learningDate;
  private String learningState;
  private int learningProgress;
  private double accuracy;

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("GetLearningStatusListResponseDto{");
    sb.append("id=").append(id);
    sb.append(", name='").append(name).append('\'');
    sb.append(", learningDate=").append(learningDate);
    sb.append(", learningState='").append(learningState).append('\'');
    sb.append(", learningProgress=").append(learningProgress);
    sb.append(", accuracy=").append(accuracy);
    sb.append('}');
    return sb.toString();
  }
}
