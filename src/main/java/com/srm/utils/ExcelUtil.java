package com.srm.utils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.*;

public class ExcelUtil {

    public static Object[][] getData(String fileName, String sheetName) {

        List<Object[]> dataList = new ArrayList<>();

        try {
            InputStream is = ExcelUtil.class
                    .getClassLoader()
                    .getResourceAsStream(fileName);

            Workbook wb = WorkbookFactory.create(is);
            Sheet sheet = wb.getSheet(sheetName);

            int rows = sheet.getPhysicalNumberOfRows();
            int cols = sheet.getRow(0).getPhysicalNumberOfCells();

            for (int i = 1; i < rows; i++) {

                Row row = sheet.getRow(i);

                if (row == null) continue;

                Cell firstCell = row.getCell(0);
                if (firstCell == null || firstCell.toString().trim().isEmpty()) {
                    continue;
                }

                Object[] rowData = new Object[cols];

                for (int j = 0; j < cols; j++) {

                    Cell cell = row.getCell(j);

                    if (cell == null) {
                        rowData[j] = "";
                    } else {
                        rowData[j] = cell.toString();
                    }
                }

                dataList.add(rowData);
            }

            wb.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        Object[][] data = new Object[dataList.size()][];

        for (int i = 0; i < dataList.size(); i++) {
            data[i] = dataList.get(i);
        }

        return data;
    }
}