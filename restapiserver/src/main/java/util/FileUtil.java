package util;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileUtil {

  protected List<List<String>> getRecords(MultipartFile multipartFile) throws IOException {
    List<List<String>> records = new ArrayList<>();
    try (CSVReader csvReader = new CSVReader(getReader(multipartFile))) {
      String[] values;
      while ((values = csvReader.readNext()) != null) {
        records.add(Arrays.asList(values));
      }
    } catch (IOException | CsvValidationException e) {
      throw new IOException();
    }
    return records;
  }

  private Reader getReader(MultipartFile file) throws IOException {
    return new BufferedReader(new InputStreamReader(file.getInputStream()));
  }

}
