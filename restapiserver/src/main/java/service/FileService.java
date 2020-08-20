package service;

import dto.FileDto;
import error.ColumnDescriptionIsNumericException;
import error.FileNotFoundException;
import mapper.FileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import util.FileValidCheckUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Service
public class FileService {

  @Autowired
  private FileMapper mapper;

  public List<FileDto> selectList() {
    return mapper.selectList();
  }

  public String selectPathById(int id) {
    String path = mapper.selectPathById(id);
    if (path == null)
      throw new FileNotFoundException();
    return path;
  }

  @Transactional
  public void upload(MultipartFile multipartFile) throws IOException {
    System.out.println(FileValidCheckUtil.getInstance().validFile(multipartFile));
  }

}
