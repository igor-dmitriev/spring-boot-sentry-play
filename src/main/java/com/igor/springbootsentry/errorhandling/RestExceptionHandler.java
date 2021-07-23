package com.igor.springbootsentry.errorhandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class RestExceptionHandler {
  @ResponseBody
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(value = {Exception.class})
  public ApiErrors unhandledException(Exception ex) {
    log.error(ex.getMessage(), ex);
    return ApiErrors.create("Server Error", "");
  }

  @ResponseBody
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(value = {MissingServletRequestParameterException.class})
  public ApiErrors missingServletRequestParameterException(
      MissingServletRequestParameterException ex) {
    log.error(ex.getMessage(), ex);
    return ApiErrors.create(HttpStatus.BAD_REQUEST.toString(), ex.getMessage());
  }
}
