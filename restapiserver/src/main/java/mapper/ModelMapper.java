package mapper;

import dto.LearningDto;
import dto.ModelDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

public interface ModelMapper {

  @Options(useGeneratedKeys = true, keyProperty = "id")
  @Insert("insert into model (modelPath, diagramPath, createdDate, learningId) values " +
      "(#{modelPath}, #{diagramPath}, now(), #{learningId})")
  void insert(ModelDto ModelDto);

}
