package controller;

import dto.ColumnAndDataDto;
import dto.FileDto;
import dto.PostUploadDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import service.ColumnService;
import service.DataService;
import service.FileService;
import service.MemberService;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@RestController
public class FileController {

  @Autowired
  private FileService fileService;
  @Autowired
  private MemberService memberService;
  @Autowired
  private ColumnService columnService;
  @Autowired
  private DataService dataService;

  @GetMapping("/files/{id}")
  public List<FileDto> getFiles(@PathVariable int id) {
    return fileService.selectListByMemberId(id);
  }

  @PostMapping("/upload")
  @Transactional
  public PostUploadDto upload(@RequestParam("file") MultipartFile file,
                              @RequestParam String email,
                              @RequestParam boolean isPublic,
                              @RequestParam String description) throws IOException {
    fileService.selectByName(Objects.requireNonNull(file.getOriginalFilename()).replace(".csv", ""));
    List<List<String>> records = fileService.saveFileToStorage(file);
    int memberId = memberService.selectIdByEmail(email);
    int fileId = fileService.insertFileToDatabase(file, description, isPublic, memberId);
    List<ColumnAndDataDto> columnAndDataList = columnService.insertColumns(records, fileId);
    dataService.insertData(columnAndDataList);
    return new PostUploadDto(fileId);
  }

}
