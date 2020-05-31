package service;

import dto.File;
import mapper.FileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {

  @Autowired
  private FileMapper mapper;

  public List<File> selectList() {
    return mapper.selectList();
  }

}
