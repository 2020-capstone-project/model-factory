package mapper;

import dto.LayerDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

public interface LayerMapper {

  @Insert("insert into layer (number, activationFunction, neuronCount, modelId) " +
      "values (#{number}, #{activationFunction}, #{neuronCount}, #{modelId})")
  void insert(@Param("number") int number,
              @Param("activationFunction") String activationFunction,
              @Param("neuronCount") int neuronCount,
              @Param("modelId") int modelId);

}
