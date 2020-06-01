package service;

import dto.MemberDto;
import error.DuplicateEmailException;
import error.MemberNotFoundException;
import error.WrongPasswordException;
import mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

  @Autowired
  private MemberMapper memberMapper;

  public MemberDto login(String email, String password) {
    MemberDto memberDto = memberMapper.selectOneByEmail(email);
    if (memberDto == null)
      throw new MemberNotFoundException();
    if (!memberDto.matchPassword(password))
      throw new WrongPasswordException();
    return memberDto;
  }

  public void signUp(String name, String email, String password) {
    MemberDto memberDto = memberMapper.selectOneByEmail(email);
    if (memberDto != null)
      throw new DuplicateEmailException();
    memberMapper.insert(name, email, password);
  }

//  public Member getInfo(String email) {
//    Member member = memberMapper.selectOneByEmail(email);
//    if (member == null)
//      throw new MemberNotFoundException();
//    return member;
//  }

  public void update(String name, String password, String email) {
    MemberDto memberDto = memberMapper.selectOneByEmail(email);
    if (memberDto == null)
      throw new MemberNotFoundException();
    memberMapper.update(name, password, email);
  }

}
