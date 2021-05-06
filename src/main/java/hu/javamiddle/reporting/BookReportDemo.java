package hu.javamiddle.reporting;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BookReportDemo {

    public static void main(String[] args) {
        List<Book> books = IntStream.range(0, 20)
                .mapToObj(e -> new Book())
                .collect(Collectors.toList());

//        System.out.println(books);

        Path xmlPath = Paths.get("books.xlsx");

        try (OutputStream out = Files.newOutputStream(xmlPath)) {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet demoSheet = workbook.createSheet("books");

            XSSFRow headerRow = demoSheet.createRow(0);

            List<String> headerTitles = Stream.of("title", "author", "genre").collect(Collectors.toList());
            for (int i = 0; i < headerTitles.size(); i++) {
                XSSFCell cell = headerRow.createCell(i, CellType.STRING);
                cell.setCellValue(headerTitles.get(i));
            }

            for (int i = 0; i < books.size(); i++) {
                Book book = books.get(i);

                XSSFRow row = demoSheet.createRow(i + 1);

                XSSFCell titleCell = row.createCell(0);
                titleCell.setCellValue(book.getTitle());

                XSSFCell authorCell = row.createCell(1);
                authorCell.setCellValue(book.getAuthor());

                XSSFCell genreCell = row.createCell(2);
                genreCell.setCellValue(book.getGenre());

            }

            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
