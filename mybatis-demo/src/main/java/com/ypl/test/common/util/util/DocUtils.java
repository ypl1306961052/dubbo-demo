package com.ypl.test.common.util.util;


import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.extractor.ExtractorFactory;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.*;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DocUtils {
    public static void genDoc(InputStream bis, String destFilePth, Map<String, Object> param,
                              List<Map<String, Object>> param2, String font, Integer fontSize, Boolean bold) {
        try {
            POIXMLTextExtractor extractor = (POIXMLTextExtractor) ExtractorFactory.createExtractor(bis);
            POIXMLDocument document = extractor.getDocument();
            //OPCPackage pack = POIXMLDocument.openPackage(srcFilePath);
            XWPFDocument doc = (XWPFDocument) document;

            replaceInPara(doc, param);
            //替换段落中的内容
            if (param2.size() > 0) {
                replaceInTableList1(doc, param2, font, fontSize, bold);
            }

            FileOutputStream fos = new FileOutputStream(destFilePth);
            doc.write(fos);
            fos.flush();
            fos.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    public static void genDoc1(String srcFilePath, String destFilePth, List<Map<String, Object>> param) {
        try {
            OPCPackage pack = POIXMLDocument.openPackage(srcFilePath);
            XWPFDocument doc = new XWPFDocument(pack);

            //替换段落中的内容
            if (param.size() > 0) {
                replaceInTableList2(doc, param, null, null);
            }

            FileOutputStream fos = new FileOutputStream(destFilePth);
            doc.write(fos);
            fos.flush();
            fos.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    public static void replaceInPara(XWPFDocument doc, Map<String, Object> params) {
        try {
//			OPCPackage pack = POIXMLDocument.openPackage(srcFilePath);
//		     XWPFDocument doc = new XWPFDocument(pack) ;
            Iterator<XWPFParagraph> paragraphIt = doc.getParagraphsIterator();
            while (paragraphIt.hasNext()) {
                XWPFParagraph paragraph = paragraphIt.next();

                Iterator<String> keyItr = params.keySet().iterator();
                while (keyItr.hasNext()) {
                    String key = keyItr.next();
                    if (paragraph.getParagraphText().indexOf(key) != -1) {
                        List<XWPFRun> run = paragraph.getRuns();
                        for (int i = 0; i < run.size(); i++) {
                            System.out.println("===" + run.get(i).getText(run.get(i).getTextPosition()));
                            if (run.get(i).getText(run.get(i).getTextPosition()) != null && run.get(i).getText(run.get(i).getTextPosition()).trim().equals(key)) {
                                /**参数0表示生成的文字是要从哪一个地方开始放置,一开始这里的代码是
                                 * run.get(i).setText("AAAA",run.get(i).getTextPosition());
                                 * 结果AAAA总是添加到要被替换的文字之后,经查看API知道,设置文字从位置0开始
                                 * 就可以把原来的文字全部替换掉了* */
                                run.get(i).setText((String) params.get(key), 0);
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    /**
     * 替换表格里面的变量
     *
     * @param doc    要替换的文档
     * @param params 参数
     */
    public static void replaceInTable(XWPFDocument doc, Map<String, Object> params, String font, Integer fontSize, Boolean bold) {
        Iterator<XWPFTable> iterator = doc.getTablesIterator();
        XWPFTable table;
        List<XWPFTableRow> rows;
        List<XWPFTableCell> cells;
        List<XWPFParagraph> paras;
        while (iterator.hasNext()) {
            table = iterator.next();
            rows = table.getRows();
//            int i =1;
            for (XWPFTableRow row : rows) {
//            	i++;
                cells = row.getTableCells();
                for (XWPFTableCell cell : cells) {
                    paras = cell.getParagraphs();
                    for (XWPFParagraph para : paras) {
                        replaceInPara(para, params, font, fontSize, bold);

                    }
                }
            }
//            addOrRemoveRow(table,1,2,params);
        }
    }

    /**
     * 替换表格里面的变量
     *
     * @param doc    要替换的文档
     * @param params 参数
     */
    public static void replaceInTableList(XWPFDocument doc, List<Map<String, Object>> params, String font, Integer fontSize, Boolean bold) {
        Iterator<XWPFTable> iterator = doc.getTablesIterator();
        XWPFTable table;
        List<XWPFTableRow> rows;
        List<XWPFTableCell> cells;
        List<XWPFParagraph> paras;
        while (iterator.hasNext()) {
            table = iterator.next();
            rows = table.getRows();
//            int i =1;
            for (XWPFTableRow row : rows) {
//            	i++;
                cells = row.getTableCells();
                for (XWPFTableCell cell : cells) {
                    paras = cell.getParagraphs();
                    for (XWPFParagraph para : paras) {
                        int index = 0;
                        for (Map<String, Object> map : params) {
                            if (index == 0) {
                                replaceInPara(para, map, font, fontSize, bold);
                            } else {
                                addOrRemoveRow(table, 1, index, map);
                            }
                            index++;
                        }
                    }
                }
            }

        }
    }

    public static void replaceInTableList1(XWPFDocument doc, List<Map<String, Object>> list, String font, Integer fontSize, Boolean bold) {
        Iterator<XWPFTable> iterator = doc.getTablesIterator();
        XWPFTable table;
        List<XWPFTableRow> rows;
        List<XWPFTableCell> cells;
        List<XWPFParagraph> paras;
        while (iterator.hasNext()) {
            table = iterator.next();
            rows = table.getRows();
            int i = 0;
            for (Map<String, Object> params : list) {
                i++;
                //第一行
                if (i == 1) {
                    for (XWPFTableRow row : rows) {
                        cells = row.getTableCells();
                        for (XWPFTableCell cell : cells) {
                            paras = cell.getParagraphs();
                            for (XWPFParagraph para : paras) {
                                replaceInPara(para, params, font, fontSize, bold);

                            }
                        }
                    }
                } else {
                    addOrRemoveRow(table, 1, i, params);
                }

            }

        }
    }

    public static void replaceInTableList2(XWPFDocument doc, List<Map<String, Object>> list, String font, Integer fontSize) {
        Iterator<XWPFTable> iterator = doc.getTablesIterator();
        XWPFTable table;
        List<XWPFTableRow> rows;
        List<XWPFTableCell> cells;
        List<XWPFParagraph> paras;
        while (iterator.hasNext()) {
            table = iterator.next();
            rows = table.getRows();
            int i = 0;
            for (Map<String, Object> params : list) {
                i++;
                //第一行
                if (i == 1) {
                    for (XWPFTableRow row : rows) {
                        cells = row.getTableCells();
                        for (XWPFTableCell cell : cells) {
                            paras = cell.getParagraphs();
                            for (XWPFParagraph para : paras) {
                                replaceInPara1(para, params, font, fontSize);

                            }
                        }
                    }
                } else {
                    addOrRemoveRow1(table, 1, i, params);
                }

            }

        }
    }

    private static void addOrRemoveRow(XWPFTable table, int add, int fromRow, Map<String, Object> param) {
        XWPFTableRow row = table.getRow(fromRow - 1);
        if (add > 0) {
            while (add > 0) {
                copyPro(row, table.insertNewTableRow(fromRow), param);
                add--;
            }
        } else {
            while (add < 0) {
                table.removeRow(fromRow - 1);
                add++;
            }
        }
    }

    private static void addOrRemoveRow1(XWPFTable table, int add, int fromRow, Map<String, Object> param) {
        XWPFTableRow row = table.getRow(fromRow - 1);
        if (add > 0) {
            while (add > 0) {
                copyPro1(row, table.insertNewTableRow(fromRow), param);
                add--;
            }
        } else {
            while (add < 0) {
                table.removeRow(fromRow - 1);
                add++;
            }
        }
    }


    private static void copyPro(XWPFTableRow sourceRow, XWPFTableRow targetRow, Map<String, Object> param) {
        // 复制行属性
        targetRow.getCtRow().setTrPr(sourceRow.getCtRow().getTrPr());
        List<XWPFTableCell> cellList = sourceRow.getTableCells();
        if (null == cellList) {
            return;
        }
        // 添加列、复制列以及列中段落属性
        XWPFTableCell targetCell = null;
//		 Set<String> keySet = param.keySet();
//	     Iterator<String> iter = keySet.iterator();
        int i = 0;
        for (XWPFTableCell sourceCell : cellList) {
            targetCell = targetRow.addNewTableCell();
            //设置各列的值
            if (i == 0) {
                targetCell.setText((String) param.get("${code}"));
            }
            if (i == 1) {
                targetCell.setText((String) param.get("${spec}"));
            }
            if (i == 2) {
                targetCell.setText((String) param.get("${msunitno}"));
            }
            if (i == 3) {
                targetCell.setText((String) param.get("${producer}"));
            }
            if (i == 4) {
                targetCell.setText((String) param.get("${price}"));
            }
            if (i == 5) {
                targetCell.setText((String) param.get("${rebat}"));
            }
            if (i == 6) {
                targetCell.setText((String) param.get("${percent}"));
            }


            i++;


            // 列属性
            targetCell.getCTTc().setTcPr(sourceCell.getCTTc().getTcPr());
            // 段落属性
            targetCell.getParagraphs().get(0).getCTP().setPPr(sourceCell.getParagraphs().get(0).getCTP().getPPr());
        }
    }

    private static void copyPro1(XWPFTableRow sourceRow, XWPFTableRow targetRow, Map<String, Object> param) {
        // 复制行属性
        targetRow.getCtRow().setTrPr(sourceRow.getCtRow().getTrPr());
        List<XWPFTableCell> cellList = sourceRow.getTableCells();
        if (null == cellList) {
            return;
        }
        // 添加列、复制列以及列中段落属性
        XWPFTableCell targetCell = null;
//		 Set<String> keySet = param.keySet();
//	     Iterator<String> iter = keySet.iterator();
        int i = 0;
        for (XWPFTableCell sourceCell : cellList) {
            targetCell = targetRow.addNewTableCell();
            //设置各列的值
            if (i == 0) {
                targetCell.setText((String) param.get("proname"));
            }
            if (i == 1) {
                targetCell.setText((String) param.get("num0"));
            }
            if (i == 2) {
                targetCell.setText((String) param.get("num1"));
            }
            if (i == 3) {
                targetCell.setText((String) param.get("num2"));
            }
            if (i == 4) {
                targetCell.setText((String) param.get("num3"));
            }
            if (i == 5) {
                targetCell.setText((String) param.get("num4"));
            }
            if (i == 6) {
                targetCell.setText((String) param.get("num5"));
            }


            i++;


            // 列属性
            targetCell.getCTTc().setTcPr(sourceCell.getCTTc().getTcPr());
            // 段落属性
            targetCell.getParagraphs().get(0).getCTP().setPPr(sourceCell.getParagraphs().get(0).getCTP().getPPr());
        }
    }

    /**
     * 替换段落里面的变量
     *
     * @param para   要替换的段落
     * @param params 参数
     */
    public static void replaceInPara(XWPFParagraph para, Map<String, Object> params, String font, Integer fontSize, Boolean bold) {
        List<XWPFRun> runs;
//        Matcher matcher;

        if (matcher(para.getParagraphText()).find()) {
            runs = para.getRuns();

            int start = -1;
            int end = -1;
            String str = "";
            for (int i = 0; i < runs.size(); i++) {
                XWPFRun run = runs.get(i);

                String runText = run.toString();
                System.out.println("------>>>>>>>>>" + runText);
                if ('$' == runText.charAt(0) && '{' == runText.charAt(1)) {
                    start = i;
                }
                if ((start != -1)) {
                    str += runText;
                }
                if ('}' == runText.charAt(runText.length() - 1)) {
                    if (start != -1) {
                        end = i;
                        break;
                    }
                }
            }
            System.out.println("start--->" + start);
            System.out.println("end--->" + end);

            System.out.println("str---->>>" + str);

            for (int i = start; i <= end; i++) {
                para.removeRun(i);
                i--;
                end--;
                System.out.println("remove i=" + i);
            }

            for (String key : params.keySet()) {
                if (str.equals(key)) {
                    //在这里根据字数的多少来设置字体的大小 目的：不分页
                    XWPFRun run = para.createRun();
                    run.setText((String) params.get(key));
                    if (font != null) {
                        run.setFontFamily(font);
                        run.setFontSize(fontSize);
                        run.setBold(bold);
                    }
                    break;
                }
            }


        }
    }

    /**
     * 替换段落里面的变量
     *
     * @param para   要替换的段落
     * @param params 参数
     */
    public static void replaceInPara1(XWPFParagraph para, Map<String, Object> params, String font, Integer fontSize) {
        List<XWPFRun> runs;
        String str = para.getParagraphText();
        if (str.startsWith("${")) {
            runs = para.getRuns();

            for (int i = runs.size() - 1; i >= 0; i--) {
                para.removeRun(i);
            }
            str = str.substring(2, str.length() - 1);
            for (String key : params.keySet()) {
                if (str.equals(key)) {
                    XWPFRun run = para.createRun();
                    run.setText((String) params.get(key));
                    if (font != null) {
                        run.setFontFamily(font);
                        run.setFontSize(fontSize);
                        run.setBold(true);
                    }
                    break;
                }
            }

        }
    }

    /**
     * 正则匹配字符串
     *
     * @param str
     * @return
     */
    private static Matcher matcher(String str) {
        Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        return matcher;
    }


    public static void main(String[] args) {

    }

}
