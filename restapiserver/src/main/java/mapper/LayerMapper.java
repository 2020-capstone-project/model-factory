package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.postgresql.util.PGobject;

public interface LayerMapper {

  @Insert("insert into layer (number, information, modelId) " +
      "values (#{number}, #{information}, #{modelId})")
  void insert(@Param("number") int number,
              @Param("information") PGobject information,
              @Param("modelId") int modelId);

}
