package mapper;

import dto.FileDto;
import dto.FileUploadDto;
import dto.PostHistoryRequestDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FileMapper {

  @Select("select f.id, f.name, f.description from _file f, member m " +
      "where f.memberId = m.id and (f.ispublic = true or f.memberId = #{id})")
  List<FileDto> selectListByMemberId(int id);

  @Select("select path from _file where id = #{id}")
  String selectPathById(@Param("id") int id);

  @Options(useGeneratedKeys = true, keyProperty = "id")
  @Insert("insert into _file (name, path, description, " +
      "memberId, isPublic) values " +
      "(#{name}, #{path}, #{description}, " +
      "#{memberId}, #{isPublic})")
  void insert(FileUploadDto fileUploadDto);

}
