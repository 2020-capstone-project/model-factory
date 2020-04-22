package controller;

import command.LoginRequest;
import command.SignUpRequest;
import dto.Member;
import error.DuplicateEmailException;
import error.MemberNotFoundException;
import error.WrongPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.AuthService;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private AuthService service;

  @PostMapping("/login")
  public Member login(@RequestBody @Valid LoginRequest request) {
    try {
      return service.login(request.getEmail(), request.getPassword());
    } catch (MemberNotFoundException e1) {
      throw new MemberNotFoundException();
    } catch (WrongPasswordException e2) {
      throw new WrongPasswordException();
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
