package controller;

import dto.AdjustRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.AuthService;

import javax.validation.Valid;

@RestController
@RequestMapping("/info")
public class InfoController {

  @Autowired
  private AuthService authService;

  @PutMapping
  public void adjust(@RequestBody @Valid AdjustRequest request) {
      authService.login(request.getEmail(), request.getCurrentPassword());
      authService.update(request.getName(), request.getNewPassword(), request.getEmail());
  }

}
