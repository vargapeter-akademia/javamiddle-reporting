package hu.javamiddle.reporting;

import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JxlsDemo {

    public static void main(String[] args) {
        List<Book> books = IntStream.range(0, 20)
                .mapToObj(e -> new Book())
                .collect(Collectors.toList());

        Path outPath = Paths.get("books.xlsx");

        try (InputStream templateStream = JxlsDemo.class.getClassLoader().getResourceAsStream("book-template.xlsx");
             OutputStream targetStream = Files.newOutputStream(outPath)) {

            JxlsHelper instance = JxlsHelper.getInstance();

            Context context = new Context();
            context.putVar("books", books);

            instance.processTemplate(templateStream, targetStream, context);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
