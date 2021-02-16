package util;

import error.ColumnDescriptionIsNumericException;
import error.MinExistValueSizeException;
import error.NotExistValueException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class FileValidCheckUtil extends FileUtil {

  private FileValidCheckUtil() {}

  public static FileValidCheckUtil fileValidCheckUtil = new FileValidCheckUtil();

  public static FileValidCheckUtil getInstance() {
    return fileValidCheckUtil;
  }

  public boolean validFile(MultipartFile multipartFile) throws IOException {
    return validRecords(getRecords(multipartFile));
  }

  public boolean validRecords(List<List<String>> records) {
    if (records == null || records.size() == 0)
      throw new NotExistValueException();
    if (!columnDescriptionIsNotNumeric(records))
      throw new ColumnDescriptionIsNumericException();
    records.remove(0);
    records.remove(0);
    if (!existAllValue(records))
      throw new NotExistValueException();
    if (records.size() < 102)
      throw new MinExistValueSizeException();
    return true;
  }

  private boolean isNotNumeric(String s) {
    try {
      Double.parseDouble(s);
      return false;
    } catch (NumberFormatException e) {
      return true;
    }
  }

  private boolean existAllValue(List<List<String>> records) {
    return records
        .parallelStream()
        .flatMap(Collection::stream)
        .allMatch(str -> !str.isEmpty() && !isNotNumeric(str));
  }

  private boolean columnDescriptionIsNotNumeric(List<List<String>> records) {
    return Stream.of(records.get(0), records.get(1))
        .flatMap(Collection::stream)
        .allMatch(str -> isNotNumeric(str) && !str.isEmpty());
  }

}
