package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LayerDto {

  private int number;
  private HashMap<String, Object> information;

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("LayerDto{");
    sb.append("number=").append(number);
    sb.append(", information=").append(information);
    sb.append('}');
    return sb.toString();
  }

}
