//import com.opencsv.CSVReader;
//import com.opencsv.exceptions.CsvValidationException;
//import error.ColumnDescriptionIsNumericException;
//import error.NotExistValueException;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Stream;
//
//public class UploadTest {
//
//  private final String DIRECTORY_PATH = "/Users/sangminlee/model-factory/restapiserver/src/main/resources/files/";
//
//  private List<List<String>> getRecords(MultipartFile multipartFile) throws IOException {
//    List<List<String>> records = new ArrayList<>();
//    try (CSVReader csvReader = new CSVReader(getFileReader(multipartFile.getName()))) {
//      String[] values;
//      while ((values = csvReader.readNext()) != null) {
//        records.add(Arrays.asList(values));
//      }
//    } catch (IOException | CsvValidationException e) {
//      throw new IOException();
//    }
//    return records;
//  }
//
//  private FileReader getFileReader(String fileName) throws FileNotFoundException {
//    return new FileReader(DIRECTORY_PATH + fileName + ".csv");
//  }
//
//  public boolean validRecords(List<List<String>> records) {
//    if (!columnDescriptionIsNotNumeric(records))
//      throw new ColumnDescriptionIsNumericException();
//    records.remove(0);
//    records.remove(0);
//    if (!existAllValue(records))
//      throw new NotExistValueException();
//    return true;
//  }
//
//  private boolean isNotNumeric(String s) {
//    try {
//      Double.parseDouble(s);
//      return false;
//    } catch (NumberFormatException e) {
//      return true;
//    }
//  }
//
//  private boolean existAllValue(List<List<String>> records) {
//    return records
//        .parallelStream()
//        .flatMap(Collection::stream)
//        .allMatch(str -> !str.isBlank() && !isNotNumeric(str));
//  }
//
//  private boolean columnDescriptionIsNotNumeric(List<List<String>> records) {
//    return Stream.of(records.get(0), records.get(1))
//        .flatMap(Collection::stream)
//        .allMatch(str -> isNotNumeric(str) && !str.isBlank());
//  }
//
//  public boolean validFile(MultipartFile multipartFile) throws IOException {
//    return validRecords(getRecords(multipartFile));
//  }
//
//  public static void main(String[] args) {
//    UploadTest uploadTest = new UploadTest();
//    try {
//      System.out.println(uploadTest.validFile(null));
//    } catch (ColumnDescriptionIsNumericException e1) {
//      System.out.println("컬럼 설명");
//    } catch (NotExistValueException e2) {
//      System.out.println("값 없음");
//    }
//  }
//
//}
