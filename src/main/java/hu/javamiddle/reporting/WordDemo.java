package hu.javamiddle.reporting;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFStyles;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WordDemo {

    public static void main(String[] args) {

        Path xmlPath = Paths.get("demo.docx");

        XWPFDocument document = new XWPFDocument();

        try (OutputStream out = Files.newOutputStream(xmlPath)) {

//            XWPFStyles styles = document.getStyles();
//            styles.

            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            run.setText("Java Middle 1");
            run.addBreak();
            run.addTab();

            run = paragraph.createRun();
            run.setText("További szöveg");
            run.setBold(true);
            run.addBreak();
            run.addTab();

            run = paragraph.createRun();
            run.setText("További szöveg");
            run.setColor("32a852");
            run.addBreak();

            document.write(out);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
