package com.example.playwright.controller;

import com.example.playwright.service.EmailService;
import com.example.playwright.service.PDFConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailController {

  private final PDFConversionService pdfConversionService;
  private final EmailService emailService;

  /*
   * 이메일 전송 API
   * */

  @PostMapping("/send")
  public String sendEmail(@RequestParam String to) throws Exception {

    String url = "http://localhost:8080/demo";

    byte[] pdfData = pdfConversionService.convertPDF(url);

    emailService.sendEmail(to, pdfData);

    return "Email Sent";
  }
}
