package controller;

import dto.PostHistoryRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.HistoryService;

@RestController
public class HistoryController {

  @Autowired
  HistoryService service;

  @PostMapping("/history")
  public void postHistory(@RequestBody PostHistoryRequestDto dto) {
    service.insert(dto);
  }

}
