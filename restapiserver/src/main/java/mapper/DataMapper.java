package mapper;

import dto.DataDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DataMapper {

  @Select("select value from data where columnId = #{id}")
  List<DataDto> selectListByColumnId(@Param("id") int id);

  @Insert("insert into data (value, columnId) values " +
      "(#{value}, #{id})")
  void insert(@Param("value") String value, @Param("id") int columnId);

}
