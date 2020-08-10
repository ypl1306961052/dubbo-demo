package com.ypl.test.common.util.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @Author: liyafei
 * @Version V1.0
 * @Description AES解密工具类
 * @Date: 2020/5/25 11:32
 */


public class MsAesCbc {

    /**加密用的Key 可以用26个字母和数字组成，此处使用AES-128-CBC加密模式，key需要为16位。*/
    /**
     * 同微软约定的key秘钥
     */
    private static String sKey = "5TGB&YX24J576V24";
    /**
     * 同微软约定的iv参数
     */
    private static String ivParameter = "X#EDC4RFV!QAZ2WS";

    private static MsAesCbc instance = null;

    private MsAesCbc() {

    }

    public static MsAesCbc getInstance() {
        if (instance == null) {
            instance = new MsAesCbc();
        }
        return instance;
    }

    public String decryptForMs(String sSrc) throws Exception {
        try {
            SecretKeySpec skeySpec = new SecretKeySpec(sKey.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] encrypted1 = Base64.decodeBase64(sSrc);
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original, "utf-8");
            return originalString;
        } catch (Exception ex) {
            return null;
        }
    }

    public static void main(String[] args) {
        try {
            String decrypt = MsAesCbc.getInstance().decryptForMs("z9kAZGH2r3MOT3wpnWVmVvVJZPWwAfqqC2/3zNmHQy34MVfIDIEotyGoJEuLxfq0");
            System.out.println(decrypt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}