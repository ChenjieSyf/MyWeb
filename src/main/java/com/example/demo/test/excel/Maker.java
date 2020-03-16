package com.example.demo.test.excel;

import com.example.demo.test.entity.ExcelData;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Maker {
    public static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");

    public volatile static int all_index = 0;

    public static void writeExcel(Map<String, List<ExcelData>> dataMap) throws IOException {
        //创建工作簿
        XSSFWorkbook workBook = new XSSFWorkbook();
        //创建工作表
        XSSFSheet sheet = workBook.createSheet("发布汇总");

        //创建头
        String headers[] = new String[]{"系统", "发布内容", "发布日期", "发布人"};
        Row headerRow = sheet.createRow(0);
        headerRow.setHeight((short) 200);
        for (int i = 0; i < headers.length; i++) {
            //设置列宽   基数为256
            sheet.setColumnWidth(i, 30 * 256);
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        if (!CollectionUtils.isEmpty(dataMap)) {
            dataMap.forEach((k, v) -> {
                makeCell(v, sheet);
            });
        }


        long time = System.currentTimeMillis();
        String excelName = "publish" + time + ".xlsx";
        FileOutputStream outputStream = new FileOutputStream(new File("C:\\Users\\jie.chenj\\Desktop\\文档\\" + excelName));
        workBook.write(outputStream);

        workBook.close();//记得关闭工作簿
    }

    private static void makeCell(List<ExcelData> dataList, Sheet sheet) {
        for (int i = 0; i < dataList.size(); i++) {
            Row row = sheet.createRow(all_index + 1);
            ExcelData excelData = dataList.get(i);
            Cell cell = row.createCell(0);
            cell.setCellValue(excelData.getAppName());

            Cell cell1 = row.createCell(1);
            cell1.setCellValue(excelData.getPublishContext());

            Cell cell2 = row.createCell(2);
            cell2.setCellValue(SDF.format(new Date(excelData.getPublishDate())));

            Cell cell3 = row.createCell(3);
            cell3.setCellValue(excelData.getOwnerName());
            all_index++;

        }
    }

}
