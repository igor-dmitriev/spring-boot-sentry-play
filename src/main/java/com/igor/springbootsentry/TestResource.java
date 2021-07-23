package com.igor.springbootsentry;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResource {
  @GetMapping("/test")
  public String test() {
    throwError();
    return "test";
  }

  private void throwError() {
    throw new RuntimeException("FAILED!!!");
  }
}
