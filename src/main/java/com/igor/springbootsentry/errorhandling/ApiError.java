package com.igor.springbootsentry.errorhandling;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ApiError {
  private final String title;
  private final String detail;
  private final ErrorCode errorCode;
}
