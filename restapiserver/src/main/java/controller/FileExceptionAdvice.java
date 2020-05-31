package controller;

import error.ErrorResponse;
import error.FileNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FileExceptionAdvice {

  @ExceptionHandler(FileNotFoundException.class)
  public ResponseEntity<ErrorResponse> fileNotFound() {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(new ErrorResponse("파일을 찾을 수 없습니다."));
  }

}
