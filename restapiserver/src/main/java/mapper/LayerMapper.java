package mapper;

import dto.LayerDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

public interface LayerMapper {

  @Insert("insert into layer (number, activationFunction, neuronCount, modelId) " +
      "values (#{number}, #{activationFunction}, #{neuronCount}, #{modelId})")
  void insert(LayerDto layerDto);

}
