package mapper;

import dto.LayerDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

public interface LayerMapper {

  @Insert("insert into layer (number, activationFunction, neuronCount, learningId) " +
      "values (#{number}, #{activationFunction}, #{neuronCount}, #{learningId})")
  void insert(LayerDto layerDto);

}
