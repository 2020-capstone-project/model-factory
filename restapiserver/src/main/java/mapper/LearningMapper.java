package mapper;

import dto.LearningDto;
import org.apache.ibatis.annotations.*;

public interface LearningMapper {

  @Options(useGeneratedKeys = true, keyProperty = "id")
  @Insert("insert into learning (batchSize, epoch, lossFunction, optimizerFunction, learningDate, memberId) " +
      "values (#{batchSize}, #{epoch}, #{lossFunction}, #{optimizerFunction}, now(), #{memberId})")
  void insert(LearningDto learningDto);

}
