package service;

import dto.MemberDto;
import error.MemberNotFoundException;
import mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

  @Autowired
  private MemberMapper memberMapper;

  public int selectIdByEmail(String email) {
    MemberDto memberDto = memberMapper.selectOneByEmail(email);
    if (memberDto == null)
      throw new MemberNotFoundException();
    return memberDto.getId();
  }

}
