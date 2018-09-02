package org.moita.sb2.handler;

import org.moita.sb2.exception.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(annotations = {RestController.class})
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<ApiError> handleAllExceptions(Exception ex, WebRequest request) {
    ApiError error = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), ex);
    return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(EmployeeNotFoundException.class)
  public final ResponseEntity<ApiError> handleUserNotFoundException(EmployeeNotFoundException ex, WebRequest request) {
    ApiError error = new ApiError(HttpStatus.NOT_FOUND, ex.getLocalizedMessage(), ex);
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }
}