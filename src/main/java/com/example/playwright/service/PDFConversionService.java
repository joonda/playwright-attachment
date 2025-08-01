package com.example.playwright.service;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.Margin;
import org.springframework.stereotype.Service;

@Service
public class PDFConversionService {

  /*
  * 뷰 템플릿 URL 및 세션 값을 활용해 PDF로 변환
  * */
  public byte[] convertPDF(String url) throws Exception {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));

      Page page = browser.newPage();
      page.navigate(url);

      byte[] pdfBytes = page.pdf(new Page.PdfOptions()
        .setFormat("A4")
        .setPrintBackground(true)
        .setMargin(new Margin()
          .setTop("12.7mm")
          .setBottom("12.7mm")
          .setLeft("12.7mm")
          .setRight("12.7mm")
        )
      );

      browser.close();
      return pdfBytes;
    }
  }
}
