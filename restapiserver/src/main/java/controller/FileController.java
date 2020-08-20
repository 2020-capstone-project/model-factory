package controller;

import dto.FileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import service.FileService;
import util.FileValidCheckUtil;

import java.io.IOException;
import java.util.List;

@RestController
public class FileController {

  @Autowired
  private FileService service;

  @GetMapping("/files")
  public List<FileDto> getFiles() {
    return service.selectList();
  }

  @PostMapping("/upload")
  public void upload(@RequestParam MultipartFile file) throws IOException {
    service.upload(file);
  }

}
