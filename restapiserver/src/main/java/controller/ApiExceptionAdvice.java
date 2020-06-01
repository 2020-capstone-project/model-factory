package controller;

import error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

@RestControllerAdvice("controller")
public class ApiExceptionAdvice {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponse> invalidException(
      MethodArgumentNotValidException ex) {
    String errorCodes = ex.getBindingResult().getAllErrors()
        .stream()
        .map(error -> Objects.requireNonNull(error.getCodes())[1] + ": " + error.getDefaultMessage())
        .collect(Collectors.joining(" ,"));
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(new ErrorResponse(errorCodes));
  }

  @ExceptionHandler(NumberFormatException.class)
  public ResponseEntity<ErrorResponse> bindException() {
    return ResponseEntity
        .status(HttpStatus.BAD_REQUEST)
        .body(new ErrorResponse("형식이 잘못된 요청입니다."));
  }

}
