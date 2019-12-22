package com.baeldung.poi.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadCellValueNotFormulaHelper {

    public Object getCellValueByFetchingLastCachedValue(String fileLocation, String cellLocation) throws IOException {
        Object cellValue = new Object();
        FileInputStream inputStream = new FileInputStream(new File(fileLocation));

        Workbook workbook = new XSSFWorkbook(inputStream);

        Sheet sheet = workbook.getSheetAt(0);

        CellAddress cellReference = new CellAddress(cellLocation);

        Row row = sheet.getRow(cellReference.getRow());
        Cell cell = row.getCell(cellReference.getColumn());

        if (cell.getCellType() == CellType.FORMULA) {
            switch (cell.getCachedFormulaResultType()) {
            case BOOLEAN:
                cellValue = cell.getBooleanCellValue();
                break;
            case NUMERIC:
                cellValue = cell.getNumericCellValue();
                break;
            case STRING:
                cellValue = cell.getRichStringCellValue()
                    .getString();
                break;
            default:
                cellValue = null;
            }
        }

        workbook.close();
        return cellValue;
    }

    public Object getCellValueByEvaluatingFormula(String fileLocation, String cellLocation) throws IOException {
        Object cellValue;
        FileInputStream inputStream = new FileInputStream(new File(fileLocation));

        Workbook workbook = new XSSFWorkbook(inputStream);

        Sheet sheet = workbook.getSheetAt(0);
        FormulaEvaluator evaluator = workbook.getCreationHelper()
            .createFormulaEvaluator();

        CellAddress cellAddress = new CellAddress(cellLocation);

        Row row = sheet.getRow(cellAddress.getRow());
        Cell cell = row.getCell(cellAddress.getColumn());

        switch (evaluator.evaluateFormulaCell(cell)) {
        case BOOLEAN:
            cellValue = cell.getBooleanCellValue();
            break;
        case NUMERIC:
            cellValue = cell.getNumericCellValue();
            break;
        case STRING:
            cellValue = cell.getStringCellValue();
            break;
        default:
            cellValue = null;
        }

        workbook.close();
        return cellValue;
    }
}
