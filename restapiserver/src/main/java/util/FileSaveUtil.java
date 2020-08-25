package util;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class FileSaveUtil extends FileUtil {

  private FileSaveUtil() {}

  private static final FileSaveUtil fileSaveUtil = new FileSaveUtil();

  public static FileSaveUtil getInstance() {
    return fileSaveUtil;
  }

  public List<List<String>> save(MultipartFile multipartFile) throws IOException {
    File targetFile = new File("/Users/sangminlee/model-factory/restapiserver/src/main/resources/files/" +
        multipartFile.getOriginalFilename());
    try {
      InputStream inputStream = multipartFile.getInputStream();
      FileUtils.copyInputStreamToFile(inputStream, targetFile);
    } catch (IOException e) {
      FileUtils.deleteQuietly(targetFile);
      throw new IOException();
    }
    return getRecords(multipartFile).subList(0, 5);
  }

}
