//package com.ypl.test.common.util.util;
//
//import com.aspose.words.Document;
//
//import java.io.File;
//
///**
// * dox转pdfl工具类
// *
// * @author redxun
// */
//public class PdfTool {
//
//
//    public static void convertDocxToPDFByaspose(String docxPath, String pdfPath) throws Exception {
//        //doc路径
//        Document document;
//        try {
//            document = new Document(docxPath);
//            //pdf路径
//            File outputFile = new File(pdfPath);
//            //操作文档保存
//            document.save(outputFile.getAbsolutePath(), com.aspose.words.SaveFormat.PDF);
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        try {
//            PdfTool.convertDocxToPDFByaspose("C://Users//34485//Desktop//11103871.doc", "C://Users//34485//Desktop//11103871.pdf");
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//}
