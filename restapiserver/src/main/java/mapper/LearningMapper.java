package mapper;

import dto.LearningDto;
import org.apache.ibatis.annotations.*;

public interface LearningMapper {

  @Options(useGeneratedKeys = true, keyProperty = "id")
  @Insert("insert into learning (batchSize, epoch, lossFunction, optimizerFunction, learningDate, memberId, name) " +
      "values (#{batchSize}, #{epoch}, #{lossFunction}, #{optimizerFunction}, now(), #{memberId}, #{name})")
  void insert(LearningDto learningDto);

}
