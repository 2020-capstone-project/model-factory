package mapper;

import dto.LayerDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.json.simple.JSONObject;
import org.postgresql.util.PGobject;

import java.util.HashMap;

public interface LayerMapper {

  @Insert("insert into layer (number, information, modelId) " +
      "values (#{number}, #{information}, #{modelId})")
  void insert(@Param("number") int number,
              @Param("information") PGobject information,
              @Param("modelId") int modelId);

}
