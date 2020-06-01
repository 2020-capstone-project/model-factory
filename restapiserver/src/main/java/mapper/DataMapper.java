package mapper;

import dto.DataDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DataMapper {

  @Select("select value from data where columnId = #{id}")
  List<DataDto> selectListByColumnId(@Param("id") int id);

}
