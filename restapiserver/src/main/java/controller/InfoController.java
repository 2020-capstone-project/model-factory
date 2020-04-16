package controller;

import command.AdjustRequest;
import command.InfoResponse;
import dto.Member;
import error.MemberNotFoundException;
import error.UnauthorizedException;
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

  @GetMapping("/{id}")
  public InfoResponse info(@PathVariable int id, HttpSession session) {
    try {
      Member member = authService.getInfo(id, session);
      return new InfoResponse(member.getName(), member.getEmail());
    } catch (MemberNotFoundException e) {
      throw new MemberNotFoundException();
    } catch (UnauthorizedException e1) {
      throw new UnauthorizedException();
    }
  }

  @PutMapping
  public void adjust(@RequestBody @Valid AdjustRequest request, HttpSession session) {
    try {
      authService.update(request.getName(), request.getPassword(), request.getEmail(), session);
    } catch (MemberNotFoundException e) {
      throw new MemberNotFoundException();
    } catch (UnauthorizedException e2) {
      throw new UnauthorizedException();
    }
  }

}
