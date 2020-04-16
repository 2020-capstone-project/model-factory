package controller;

import command.LoginRequest;
import command.LogoutRequest;
import command.SignUpRequest;
import dto.Member;
import error.DuplicateEmailException;
import error.MemberNotFoundException;
import error.UnauthorizedException;
import error.WrongPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.AuthService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private AuthService service;

  @PostMapping("/login")
  public Member login(@RequestBody @Valid LoginRequest request, HttpSession session) {
    try {
      Member member = service.login(request.getEmail(), request.getPassword());
      session.setAttribute(member.getEmail(), member);
      return member;
    } catch (MemberNotFoundException e1) {
      throw new MemberNotFoundException();
    } catch (WrongPasswordException e2) {
      throw new WrongPasswordException();
    }
  }

  @PostMapping("/logout")
  public void logout(@RequestBody @Valid LogoutRequest request, HttpSession session) {
    try {
      Member member = service.getInfo(request.getId(), session);
      session.removeAttribute(member.getEmail());
    } catch (MemberNotFoundException e) {
      throw new MemberNotFoundException();
    } catch (UnauthorizedException e2) {
      throw new UnauthorizedException();
    }
  }

  @PostMapping("/signup")
  public void signUp(@RequestBody @Valid SignUpRequest request) {
    try {
      service.signUp(request.getName(), request.getEmail(), request.getPassword());
    } catch (DuplicateEmailException e) {
      throw new DuplicateEmailException();
    }
  }

}
