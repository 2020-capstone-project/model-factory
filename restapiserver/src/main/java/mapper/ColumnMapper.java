package mapper;

import dto.ColumnDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ColumnMapper {

  @Select("select id, name, description from _column " +
      "where fileId = #{fileId}")
  List<ColumnDto> selectListByFileId(@Param("fileId") int id);

}
