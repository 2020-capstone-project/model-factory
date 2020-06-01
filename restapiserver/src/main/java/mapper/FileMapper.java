package mapper;

import dto.FileDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FileMapper {

  @Select("select id, name, description from _file")
  List<FileDto> selectList();

  @Select("select path from _file where id = #{id}")
  String selectPathById(@Param("id") int id);

}
