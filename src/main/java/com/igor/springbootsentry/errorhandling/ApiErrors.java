package com.igor.springbootsentry.errorhandling;

import java.util.Collections;
import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiErrors {

  private final List<ApiError> errors;

  public static ApiErrors create(String title, String message, ErrorCode errorCode) {
    return new ApiErrors(Collections.singletonList(new ApiError(title, message, errorCode)));
  }

  public static ApiErrors create(String message, ErrorCode errorCode) {
    return create("", message, errorCode);
  }

  public static ApiErrors create(String title, String message) {
    return create(title, message, null);
  }

  public static ApiErrors create(String message) {
    return create("", message, null);
  }
}
