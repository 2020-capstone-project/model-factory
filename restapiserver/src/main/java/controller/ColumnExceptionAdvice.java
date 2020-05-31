package controller;

import error.ColumnNotFoundException;
import error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ColumnExceptionAdvice {

  @ExceptionHandler(ColumnNotFoundException.class)
  public ResponseEntity<ErrorResponse> columnNotFound() {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(new ErrorResponse("컬럼을 찾을 수 없습니다."));
  }

}
