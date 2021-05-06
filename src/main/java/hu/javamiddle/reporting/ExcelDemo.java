package hu.javamiddle.reporting;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.*;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class ExcelDemo {

    public static void main(String[] args) {
        Path xmlPath = Paths.get("demo.xlsx");

        try (OutputStream out = Files.newOutputStream(xmlPath)) {
            XSSFWorkbook workbook = new XSSFWorkbook();

            XSSFSheet demoSheet = workbook.createSheet("demo");

            XSSFRow row = demoSheet.createRow(0);
            XSSFCell cell = row.createCell(0);

            cell.setCellValue(LocalDate.now());
            cell.setCellType(CellType.NUMERIC);

            XSSFCreationHelper creationHelper = workbook.getCreationHelper();
            XSSFCellStyle cellStyle = workbook.createCellStyle();

            XSSFDataFormat dataFormat = creationHelper.createDataFormat();
            cellStyle.setDataFormat(dataFormat.getFormat("yyyy.mm.dd."));

            cell.setCellStyle(cellStyle);

            row.createCell(1)
                    .setCellFormula("SUM(A1)");

            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
