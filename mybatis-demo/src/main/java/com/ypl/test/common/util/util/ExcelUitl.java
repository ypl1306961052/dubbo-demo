package com.ypl.test.common.util.util;
/*
作者：yangp
创建时间：2020/7/9-11:19-2020
*/


/**
 * @author wxt.yangp
 * @version V1.0
 * @Title: ExcelUitl
 * @Package com.wondersgroup.risk.common.util
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/7/9 11:19
 */

import org.apache.poi.hssf.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * excel表的工具
 */
public class ExcelUitl {

    /**
     * 生成excel表
     * @param response
     * @param excelData
     * @param sheetName
     * @param fileName
     * @param countWidth
     * @throws IOException
     */
    public static void exportExcel(HttpServletResponse response,
                                   List<List<String>> excelData,
                                   String sheetName, String fileName, int countWidth) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(sheetName);
        //设置列宽
        sheet.setDefaultColumnWidth(countWidth);
        for (int i = 0; i < excelData.size(); i++) {
            HSSFRow row = sheet.createRow(i);
            List<String> rows = excelData.get(i);
            for (int j = 0; j < rows.size(); j++) {
                //创建一个单元格
                HSSFCell cell = row.createCell(j);
                HSSFRichTextString text = new HSSFRichTextString(rows.get(j));
                cell.setCellValue(text);
            }

        }
        String encodeFileName = URLEncoder.encode(fileName + ".xls", "utf-8").replaceAll("\\+", "%20");
        //清空response中缓存
        response.reset();
        response.setHeader("Content-disposition","attachment;fileName="+encodeFileName+"");
        response.setHeader("Pragma","no-cache");
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires",0);
        response.setCharacterEncoding("utf-8");
        //刷新缓存
        response.flushBuffer();
        workbook.write(response.getOutputStream());


    }
}
