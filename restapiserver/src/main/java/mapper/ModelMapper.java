package mapper;

import dto.LearningDto;
import dto.ModelDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ModelMapper {

  @Options(useGeneratedKeys = true, keyProperty = "id")
  @Insert("insert into model (modelPath, createdDate, learningId) values " +
      "(#{modelPath}, now(), #{learningId})")
  void insert(ModelDto ModelDto);

  @Select("select modelPath from model where learningId = #{id}")
  ModelDto selectOneByLearningId(@Param("id") int learningId);

}
