package controller;

import error.*;
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

  @ExceptionHandler({ColumnDescriptionIsNumericException.class, NotExistValueException.class})
  public ResponseEntity<ErrorResponse> columnDescriptionIsNumeric() {
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(new ErrorResponse("파일의 형식이 잘못되었습니다. 파일을 점검해주세요."));
  }

  @ExceptionHandler({MinExistValueSizeException.class})
  public ResponseEntity<ErrorResponse> minExistValueSize() {
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(new ErrorResponse("파일의 데이터 개수는 최소 100개 이상입니다."));
  }

  @ExceptionHandler({SameFileNameException.class})
  public ResponseEntity<ErrorResponse> sameFileName() {
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(new ErrorResponse("동일한 이름의 파일이 이미 존재합니다."));
  }

}
