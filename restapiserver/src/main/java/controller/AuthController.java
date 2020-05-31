package controller;

import dto.LoginRequest;
import dto.SignUpRequest;
import dto.Member;
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
      return service.login(request.getEmail(), request.getPassword());
  }

  @PostMapping("/signup")
  public void signUp(@RequestBody @Valid SignUpRequest request) {
      service.signUp(request.getName(), request.getEmail(), request.getPassword());
  }

}
