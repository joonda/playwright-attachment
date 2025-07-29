package com.example.playwright.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PlaywrightController {

  @GetMapping("/demo")
  public String view() {
    return "demo";
  }
}
