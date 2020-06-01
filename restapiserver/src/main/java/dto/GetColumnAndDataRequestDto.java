package dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class GetColumnAndDataRequestDto {

  private String name;
  private String description;
  private List<String> data;

  public GetColumnAndDataRequestDto(String name, String description, List<DataDto> data) {
    this.name = name;
    this.description = description;
    this.data = data.stream()
        .map(DataDto::getValue)
        .collect(Collectors.toList());
  }
}
