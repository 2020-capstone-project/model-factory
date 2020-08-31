package service;

import dto.FileDto;
import dto.FileUploadDto;
import error.FileNotFoundException;
import error.SameFileNameException;
import mapper.FileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import util.FileSaveUtil;
import util.FileValidCheckUtil;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
public class FileService {

  private final String DIRECTORY_PATH = "/Users/sangminlee/model-factory/restapiserver/src/main/resources/files/";

  @Autowired
  private FileMapper mapper;

  public List<FileDto> selectListByMemberId(int id) {
    return mapper.selectListByMemberId(id);
  }

  public String selectPathById(int id) {
    String path = mapper.selectPathById(id);
    if (path == null)
      throw new FileNotFoundException();
    return path;
  }

  public void selectByName(String name) {
    List<String> list = mapper.selectByName(name);
    if (list != null && list.size() > 0)
      throw new SameFileNameException();
  }

  public List<List<String>> saveFileToStorage(MultipartFile multipartFile) throws IOException {
    FileValidCheckUtil.getInstance().validFile(multipartFile);
    return FileSaveUtil.getInstance().save(multipartFile);
  }

  public int insertFileToDatabase(MultipartFile file, String description, boolean isPublic, int memberId) {
    FileUploadDto fileUploadDto = FileUploadDto.builder()
        .name(Objects.requireNonNull(file.getOriginalFilename()).replace(".csv", ""))
        .description(description)
        .isPublic(isPublic)
        .memberId(memberId)
        .path(DIRECTORY_PATH + file.getOriginalFilename())
        .build();
    mapper.insert(fileUploadDto);
    return fileUploadDto.getId();
  }

}
