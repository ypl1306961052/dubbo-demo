package com.ypl.test.common.util.util;
import org.apache.commons.lang3.StringUtils;
import org.microemu.app.capture.AnimatedGifEncoder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 动态GIF验证码
 * author:lck
 */
public class CaptchaUtils {
    private static char mapTable[] = {
            '0','1', '2', '3', '4', '5', '6', '7', '8', '9'};
    //gif
    public static Map<String, Object> getImageGifCode(OutputStream os)  {
        Map<String,Object> returnMap = new HashMap<String, Object>();
        char[] codeArray = new char[4];
        for (int i = 0; i < 4; ++i) {
            codeArray[i]= mapTable[(int) (mapTable.length * Math.random())];
        }
        AnimatedGifEncoder gifEncoder = new AnimatedGifEncoder();
        gifEncoder.start(os);
        gifEncoder.setQuality(50);
        gifEncoder.setDelay(200);
        gifEncoder.setRepeat(0);
        Font font = getFont(20);
        for (int i = 0; i < codeArray.length; i++) {
            BufferedImage frame = drawCode(codeArray, font, i);
            gifEncoder.addFrame(frame);
            frame.flush();
        }
        gifEncoder.finish();
        String code = String.valueOf(codeArray);
        returnMap.put("SimpleCode",code);
        return returnMap;
    }

    //jpeg
    public static Map<String,Object> getImageJpegCode(OutputStream os){
        Map<String,Object> returnMap = new HashMap<String, Object>();
        char[] codeArray = new char[4];
        for (int i = 0; i < 4; ++i) {
            codeArray[i]= mapTable[(int) (mapTable.length * Math.random())];
        }
        Font font = getFont(20);
        BufferedImage frame = drawCode(codeArray, font, 1);
        try {
            ImageIO.write(frame,"jpeg",os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String code = String.valueOf(codeArray);
        returnMap.put("SimpleCode",code);
        return returnMap;
    }



    public static Map<String,Object> checkcode(HttpSession session, String checkCode){
        Map<String,Object> map = new HashMap<String, Object> ();
        Object cko = session.getAttribute("SimpleCode");
        checkCode = checkCode.toUpperCase();
        if (cko == null) {
            map.put("message","请输入验证码");
            map.put("code",1);
            return map;
        }
        Long codeTime = Long.valueOf(session.getAttribute("codeTime") + "");
        String captcha = cko.toString();
        if (StringUtils.isEmpty(checkCode) || captcha == null || !(checkCode.equalsIgnoreCase(captcha))) {
            map.put("message","验证码错误");
            map.put("code",1);
            return map;
        } else if ((System.currentTimeMillis() - codeTime) / 1000 / 60 > 1) {
            map.put("message","验证码已失效");
            map.put("code",1);
            return map;
        } else {
            map.put("message","通过");
            map.put("code",0);
            return map;
        }
    }



    private static BufferedImage drawCode(char[] word, Font font, int flag){
        BufferedImage image = new BufferedImage(90, 30, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = getGraphics(image, font);
        AlphaComposite ac;
        float y = ((float) (30 >> 1)) + (font.getSize() >> 1);
        float m = ((float) (90 - (word.length * font.getSize()))) / word.length;
        float x = m / 5;
        for (int i = 0; i < word.length; i++) {
            ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, getTransparency(flag, i, word.length));
            g2d.setComposite(ac);
            g2d.setColor(getRandColor(1, 255));
            mixSource(image);
            g2d.drawString(String.valueOf(word[i]), x + (font.getSize() + m) * i, y);
        }
        g2d.dispose();
        return image;
    }




    private static Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) {fc = 255;}
        if (bc > 255) {bc = 255;}
        int r = fc+random.nextInt(bc - fc);
        int g = fc+random.nextInt(bc - fc);
        int b = fc+random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

    private static void mixSource(BufferedImage image){
        drawPoint(image);
        drawLine(image);
    }

    private static void drawPoint(BufferedImage image) {
        Random random = new Random();
        int area = (int) (0.01f * 30 * 30);
        for (int i = 0; i < area; i++) {
            int x = random.nextInt(90);
            int y = random.nextInt(30);
            image.setRGB(x, y, random.nextInt(255));
        }
    }

    private static void drawLine(BufferedImage image) {
        Graphics graphics = image.getGraphics();
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            int xs = random.nextInt(90);
            int ys = random.nextInt(30);
            int xe = xs + random.nextInt(90);
            int ye = ys + random.nextInt(30);
            graphics.setColor(getRandColor(1, 255));
            graphics.drawLine(xs, ys, xe, ye);
        }
    }

    private static float getTransparency(int i, int j, int length) {
        int num = i + j;
        float r = length / length;
        float s = (length + 1) * r;
        float result = num > length ? (num * r - s) : num * r;
        result = result>1 ? 1f:result;
        return result;
    }


    private static Graphics2D getGraphics(BufferedImage image, Font font) {
        Graphics2D g2d = image.createGraphics();
        g2d.setFont(font);
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, 90, 30);
        return g2d;
    }

    private static Font getFont(int size) {
        Random random = new Random();
        Font[] font = new Font[5];
        font[0] = new Font("Ravie", Font.BOLD, size);
        font[1] = new Font("Antique Olive Compact", Font.BOLD, size);
        font[2] = new Font("Fixedsys", Font.BOLD, size);
        font[3] = new Font("Wide Latin", Font.BOLD, size);
        font[4] = new Font("Gill Sans Ultra Bold", Font.BOLD, size);
        return font[random.nextInt(font.length)];
    }
}
