package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class GetColumnAndDataRequest {

  private String name;
  private String description;
  private List<String> data;

  public GetColumnAndDataRequest(String name, String description, List<Data> data) {
    this.name = name;
    this.description = description;
    this.data = data.stream()
        .map(Data::getValue)
        .collect(Collectors.toList());
  }
}
