package controller;

import error.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice("controller")
public class AuthExceptionAdvice {

  @ExceptionHandler(MemberNotFoundException.class)
  public ResponseEntity<ErrorResponse> memberNotFound() {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(new ErrorResponse("회원을 찾을 수 없습니다."));
  }

  @ExceptionHandler(WrongPasswordException.class)
  public ResponseEntity<ErrorResponse> wrongPassword() {
    return ResponseEntity
        .status(HttpStatus.UNAUTHORIZED)
        .body(new ErrorResponse("잘못된 비밀번호 입니다."));
  }

  @ExceptionHandler(DuplicateEmailException.class)
  public ResponseEntity<ErrorResponse> duplicateEmail() {
    return ResponseEntity
        .status(HttpStatus.CONFLICT)
        .body(new ErrorResponse("이미 존재하는 이메일 입니다."));
  }

  @ExceptionHandler(UnauthorizedException.class)
  public ResponseEntity<ErrorResponse> unauthorized() {
    return ResponseEntity
        .status(HttpStatus.UNAUTHORIZED)
        .body(new ErrorResponse("인증되지 않은 접근 입니다."));
  }

}
