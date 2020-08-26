package mapper;

import dto.ColumnAndDataDto;
import dto.ColumnDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ColumnMapper {

  @Select("select id, name, description from _column " +
      "where fileId = #{fileId}")
  List<ColumnDto> selectListByFileId(@Param("fileId") int id);

  @Options(useGeneratedKeys = true, keyProperty = "id")
  @Insert("insert into _column (name, description, fileId) values " +
      "(#{name}, #{description}, #{fileId})")
  void insert(ColumnAndDataDto dataDto);

}
