package com.xlkj.website.util;

import java.util.Random;

/**
 * @Description: 编号相关工具类
 * @Auther: Created by luxuelei on 2018-11-26
 */
public class NumberUtil {

    /*车牌号识别精度*/
    public static final int TRUCK_NO_PRECISION = 5;

    /**
     * 车牌号模糊匹配算法
     *
     * @param scanTruckNo   前端识别的车牌号
     * @param actualTruckNo 后台获取到的车牌号
     * @return
     */
    public static boolean equalsTruckNo(String scanTruckNo, String actualTruckNo) {
        if (actualTruckNo != null && !"".equals(actualTruckNo) && scanTruckNo != null && !"".equals(scanTruckNo)) {
            if (scanTruckNo.length() >= TRUCK_NO_PRECISION) {
                if (actualTruckNo.equals(scanTruckNo)) {
                    return true;
                } else {
                    int precison = 0;
                    for (int i = 0; i < scanTruckNo.length(); i++) {
                        if (scanTruckNo.charAt(i) == actualTruckNo.charAt(i)) {
                            precison++;
                        }
                    }
                    if (precison >= TRUCK_NO_PRECISION) {
                        return true;
                    }
                }
            } else {
                return false;
            }

        }
        return false;
    }

   /**
    * 生成各业务模块单号
    * @param prefix
    * @return
    */
   public static String getBusinessCode(String prefix){
	   return prefix + DateUtil.getStringAllDateS();
   }


   public static String getNumRadm(String pre){

       Random random = new Random();
       int i = random.nextInt(10000);
       return pre+i+DateUtil.getStringAllDateS();

   }
}
