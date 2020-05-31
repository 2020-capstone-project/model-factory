package mapper;

import dto.Data;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DataMapper {

  @Select("select value from data where columnId = #{id}")
  List<Data> selectListByColumnId(@Param("id") int id);

}
