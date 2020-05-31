package controller;

import dto.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.FileService;

import java.util.List;

@RestController
public class FileController {

  @Autowired
  private FileService service;

  @GetMapping("/files")
  public List<File> getFiles() {
    return service.selectList();
  }

}
