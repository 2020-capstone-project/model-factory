package service;

import dto.FileDto;
import error.FileNotFoundException;
import mapper.FileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

  public void upload(MultipartFile multipartFile) {
    File targetFile = new File("/Users/sangminlee/model-factory/restapiserver/src/main/resources/files/" +
        multipartFile.getName());
    try {
      BufferedReader br = new BufferedReader(new FileReader(targetFile));
      String line = "";
      while ((line = br.readLine()) != null) {
        System.out.println("1");
        System.out.println(Arrays.toString(line.split(",", -1)));
      }
      while ((line = br.readLine()) != null) {
        System.out.println("1");
        System.out.println(Arrays.toString(line.split(",", -1)));
      }
    } catch (java.io.FileNotFoundException e) {
      throw new FileNotFoundException();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
