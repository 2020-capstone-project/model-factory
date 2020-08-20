package controller;

import error.ColumnDescriptionIsNumericException;
import error.ErrorResponse;
import error.FileNotFoundException;
import error.NotExistValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
public class FileExceptionAdvice {

  @ExceptionHandler({FileNotFoundException.class, IOException.class})
  public ResponseEntity<ErrorResponse> fileNotFound() {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(new ErrorResponse("파일을 찾을 수 없습니다."));
  }

  @ExceptionHandler(ColumnDescriptionIsNumericException.class)
  public ResponseEntity<ErrorResponse> columnDescriptionIsNumeric() {
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(new ErrorResponse("파일의 컬럼 설명은 문자로 이루어져야 합니다."));
  }

  @ExceptionHandler(NotExistValueException.class)
  public ResponseEntity<ErrorResponse> notExistValue() {
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(new ErrorResponse("파일에 빈 칸이 존재합니다. 파일의 모든 값은 존재해야 합니다."));
  }

}
