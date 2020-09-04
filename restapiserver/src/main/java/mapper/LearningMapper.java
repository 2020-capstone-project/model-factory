package mapper;

import dto.LearningDto;
import org.apache.ibatis.annotations.*;
import org.postgresql.util.PGobject;

public interface LearningMapper {

  @Options(useGeneratedKeys = true, keyProperty = "id")
  @Insert("insert into learning (batchSize, epoch, lossFunction, optimizerFunction, learningDate, memberId, name) " +
      "values (#{batchSize}, #{epoch}, #{lossFunction}, #{optimizerFunction}, now(), #{memberId}, #{name})")
  void insert(LearningDto learningDto);

  @Update("update learning " +
      "set inputcolumns = #{inputColumns}, outputcolumns = #{outputColumns} " +
      "where id = #{id}")
  void insertColumns(@Param("inputColumns") PGobject inputColumns,
                     @Param("outputColumns") PGobject outputColumns,
                     @Param("id") int id);

}
