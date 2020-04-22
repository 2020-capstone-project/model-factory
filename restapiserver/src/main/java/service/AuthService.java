package service;

import dto.Member;
import error.DuplicateEmailException;
import error.MemberNotFoundException;
import error.UnauthorizedException;
import error.WrongPasswordException;
import mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

public class AuthService {

  @Autowired
  private MemberMapper memberMapper;

  public Member login(String email, String password) {
    Member member = memberMapper.selectOneByEmail(email);
    if (member == null)
      throw new MemberNotFoundException();
    if (!member.matchPassword(password))
      throw new WrongPasswordException();
    return member;
  }

  public void signUp(String name, String email, String password) {
    Member member = memberMapper.selectOneByEmail(email);
    if (member != null)
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
    Member member = memberMapper.selectOneByEmail(email);
    if (member == null)
      throw new MemberNotFoundException();
    memberMapper.update(name, password, email);
  }

}
