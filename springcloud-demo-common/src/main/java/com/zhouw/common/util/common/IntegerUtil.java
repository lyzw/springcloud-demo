package com.zhouw.common.util.common;


import com.zhouw.common.exception.ParseException;

/**
 * Integer工具类
 *
 * @author zhouwei
 * @version v1.0
 * @cratedate 2017/5/27.
 * @since v1.0
 */
public class IntegerUtil {

    /**
     * 字符串转换为Integer
     *
     * @param value Int String值
     * @return 转换后的数字
     * @throws ParseException        类型转换异常
     * @throws NumberFormatException 数字格式化异常
     */
    public static Integer parseToInteger(String value) throws ParseException, NumberFormatException {
        if (StringUtil.isEmpty(value, true)) {
            return null;
        }
        return Integer.parseInt(value.trim());
    }

    /**
     * 将byte数组转换成数字
     *
     * @param bytes byte数组
     * @return 数字
     * @throws ParseException        转换异常
     * @throws NumberFormatException 数字格式化异常
     */
    public static Integer parseToInteger(byte[] bytes) throws ParseException, NumberFormatException {
        if (bytes == null) return null;
        String value = new String(bytes);
        if (StringUtil.isEmpty(value, true)) {
            return null;
        }
        return Integer.parseInt(value.trim());
    }

    public static Integer parseToInteger(char[] chars) {
        if (chars == null) return null;
        String value = new String(chars);
        if (StringUtil.isEmpty(value, true)) {
            return null;
        }
        try {
            return Integer.parseInt(value.trim());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 小端的数字转为为大端
     *
     * @param value 小端数字
     * @return 转换后的大端数字
     */
    public static Integer lowToInteger(Integer value) {
        return (((value & 0xFF) << 24) | (((value >> 8) & 0xFF) << 16) | (((value >> 16) & 0xFF) << 8) | ((value >> 24) & 0xFF));
    }

    public static int intToHex(Integer value){

        return Integer.parseInt("e107",16);
    }

    public static void main(String[] args) {
        System.out.println(intToHex(10));
    }
}
