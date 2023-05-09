package com.javakun.milkteaism.utils;

import com.javakun.milkteaism.model.Milktea;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

public class ExcelExport {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Milktea> listMilktea;

    public ExcelExport(List<Milktea> listMilktea) {
        this.listMilktea = listMilktea;
        workbook = new XSSFWorkbook();
    }


    private void writeHeaderLine() {
        sheet = workbook.createSheet("Milktea List");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "Milktea ID", style);
        createCell(row, 1, "Beverage Key", style);
        createCell(row, 2, "Flavor", style);
        createCell(row, 3, "Size", style);
        createCell(row, 4, "Amount", style);

    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Long) {
            cell.setCellValue((Long) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines() {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (Milktea milktea : listMilktea) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, milktea.getMilkteaId(), style);
            createCell(row, columnCount++, milktea.getBeverageKey(), style);
            createCell(row, columnCount++, milktea.getFlavor(), style);
            createCell(row, columnCount++, milktea.getSize(), style);
            createCell(row, columnCount++, milktea.getAmount(), style);

        }
    }

    @SneakyThrows
    public void export(HttpServletResponse response) {
        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();

    }
}
