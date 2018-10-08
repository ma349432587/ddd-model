package com.mango.medical.utils;

/**
 * Created by lichangjun1 on 2017/6/21.
 */
public class MaskUtil {

    //固定电话掩码
    public static String maskPhone(String phone) {
        if (phone == null || phone.length() != 11) {
            return null;
        }
        StringBuilder sb = new StringBuilder(phone);
        return sb.replace(3, 7, "****").toString();
    }

    public static String maskName(String name) {
        if (name == null || name.length() <= 1) {
            return name;
        }
        StringBuilder sb = new StringBuilder(name);
        return sb.replace(0, name.length() - 1, "**").toString();
    }

    public static String maskIdCard(String idCard) {
        if (idCard == null || (idCard.length() != 15 && idCard.length() != 18)) {
            return null;
        }
        StringBuilder sb = new StringBuilder(idCard);
        return sb.replace(3, 14, "***********").toString();
    }


    public static void main(String[] args) {
        System.out.println(maskPhone("18801072458"));
        System.out.println(maskName("马尧"));
    }


}
