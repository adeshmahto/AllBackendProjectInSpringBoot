package com.adesh.coding30min.config;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileOutputStream;
import java.io.IOException;

public class URLClassLoader {
	public static void pdfToWord(String fileCode) throws IOException {

        XWPFDocument doc = new XWPFDocument();

        String pdf = "C:\\Users\\91756\\Documents\\workspace-spring-tool-suite-4-4.16.0.RELEASE\\Coding30min\\Files-Upload\\" + fileCode + ".pdf";
        PdfReader reader = new PdfReader(pdf);
        PdfReaderContentParser parser = new PdfReaderContentParser(reader);

        for(int i = 1; i <= reader.getNumberOfPages(); i++) {
            TextExtractionStrategy strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
            String text = strategy.getResultantText();
            XWPFParagraph p = doc.createParagraph();
            XWPFRun run = p.createRun();
            run.setText(text);
            run.addBreak(BreakType.PAGE);
        }
        FileOutputStream out = new FileOutputStream("C:\\\\Users\\\\91756\\\\Documents\\\\workspace-spring-tool-suite-4-4.16.0.RELEASE\\\\Coding30min\\\\Files-Upload\\\\" + fileCode  );
        doc.write(out);
        out.close();
        reader.close();
    }
}
