package com.example.playwright.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

  private final JavaMailSender mailSender;

  public void sendEmail(String to, byte[] pdfBytes) throws MessagingException {
    MimeMessage message = mailSender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message);

    helper.setTo(to);
    helper.setSubject("Test Email");
    helper.setText("This is a test email");
    helper.addAttachment("attach.pdf", new ByteArrayResource(pdfBytes));

    mailSender.send(message);
  }
}
