package mapper;

import dto.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface MemberMapper {

  @Select("select id, name, email, password from member where email=#{email}")
  Member selectOneByEmail(@Param("email") String email);

  @Select("select id, name, email from member where id=#{id}")
  Member selectOneById(@Param("id") int id);

  @Insert("insert into member (name, email, password) " +
      "values (#{name}, #{email}, #{password})")
  void insert(@Param("name") String name, @Param("email") String email, @Param("password") String password);

  @Update("update member set name=#{name}, password=#{password} " +
      "where email=#{email}")
  void update(@Param("name") String name, @Param("password") String password, @Param("email") String email);

}
