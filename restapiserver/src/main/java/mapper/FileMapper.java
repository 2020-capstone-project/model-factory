package mapper;

import dto.File;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FileMapper {

  @Select("select id, name, description from _file")
  List<File> selectList();

}
