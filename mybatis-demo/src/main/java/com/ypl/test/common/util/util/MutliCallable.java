package com.ypl.test.common.util.util;

import com.google.common.collect.Lists;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;


public class MutliCallable implements Callable<Integer> {

    public String filePath;
    public String destPdf;
    public Map<String, Object> param;
    public String sourcePdf;
    public String font;
    public Integer fontSize;
    public Boolean bold;

    public MutliCallable(String filePath, String destPdf,
                         Map<String, Object> param, String sourcePdf, String font,
                         Integer fontSize, Boolean bold) {
        this.filePath = filePath;
        this.param = param;
        this.destPdf = destPdf;
        this.sourcePdf = sourcePdf;
        this.font = font;
        this.fontSize = fontSize;
        this.bold = bold;
    }

    public MutliCallable(String filePath, String destPdf, Map<String, Object> param,
                         String sourcePdf) {
        this.filePath = filePath;
        this.param = param;
        this.destPdf = destPdf;
        this.sourcePdf = sourcePdf;
        this.font = null;
        this.fontSize = null;
        this.bold = false;
    }

    @Override
    public Integer call() {
        List<Map<String, Object>> list = Lists.newArrayList();
        list.add(param);

        System.out.println("==========开始创建：文件路径：" + filePath);
        File file = new File(sourcePdf);
//        String path = "";
//        if (file.exists()) {
//            path = file.getAbsolutePath();
//        } else {
//            path = this.getClass().getResource(sourcePdf).getFile();
//        }
        InputStream bis = MutliCallable.class.getResourceAsStream(sourcePdf);
        DocUtils.genDoc(bis, filePath, param, list, font, fontSize, bold);
        try {
//            PdfTool.convertDocxToPDFByaspose(filePath, destPdf);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 1;
    }

}
