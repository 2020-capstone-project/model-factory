package controller;

import command.AdjustRequest;
import command.InfoRequest;
import command.InfoResponse;
import dto.Member;
import error.MemberNotFoundException;
import error.UnauthorizedException;
import error.WrongPasswordException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.AuthService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RestController
@RequestMapping("/info")
public class InfoController {

  @Autowired
  private AuthService authService;

  @PutMapping
  public void adjust(@RequestBody @Valid AdjustRequest request) {
    try {
      authService.login(request.getEmail(), request.getCurrentPassword());
      authService.update(request.getName(), request.getNewPassword(), request.getEmail());
    } catch (MemberNotFoundException e) {
      throw new MemberNotFoundException();
    } catch (WrongPasswordException e3) {
      throw new WrongPasswordException();
    }
  }

}
