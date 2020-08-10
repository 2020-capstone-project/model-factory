import error.FileNotFoundException;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class uploadTest {

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

  public static void main(String[] args) {

  }

}
