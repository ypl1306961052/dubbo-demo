package com.ypl.test.common.util.util;

//import com.wondersgroup.risk.common.constant.RiskTaskConstant;

import java.util.UUID;

/**
 * @Author: liyafei
 * @Version V1.0
 * @Description 生成taskNo
 * @Date: 2020/5/28 14:05
 */
public class TaskNoUtil {

//    public static String productTaskNo(Integer riskType) {
//        String prex = RiskTaskConstant.sourceForm(riskType);
//        String uuid = UUID.randomUUID().toString();
//        return prex + uuid.substring(uuid.length() - 10);
//    }

    public static String radomInstId() {
        String temp = StringUtil.get36UUID();
        String millis = System.currentTimeMillis() + "";
        return temp.substring(0, 28) + millis.substring(5);
    }

//    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            System.out.println(productTaskNo(1));
//        }
//    }
}
