package service;

import dto.FileDto;
import error.FileNotFoundException;
import mapper.FileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
