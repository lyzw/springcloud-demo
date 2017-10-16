package com.zhouw.common.util.common;

/**
 * 字符串处理工具类
 *
 * @author zhouwei
 * @version v1.0
 * @cratedate 2017/5/10.
 * @since v1.0
 */
public class StringUtil {

    /**
     * 检测字符串是否为空
     *
     * @param value 待检测的字符串
     * @return 如果字符串为空则
     */
    public static boolean isNull(String value) {
        return value == null ? true : false;
    }

    /**
     * 判断字符串是否为空或者“”，判断是否为“”的时候会对字符串进行trim处理
     *
     * @param value 待检测字符串
     * @return 如果为空或者“”，返回true，否则返回false
     */
    public static boolean isEmpty(String value) {
        if (isNull(value)) {
            return true;
        } else if ("".equals(value.trim())) {
            return true;
        }
        return false;
    }

    /**
     * 判断字符串是否为空或者“”，判断是否为“”的时候会对字符串进行trim处理
     *
     * @param value   待检测字符串
     * @param trimOpr 是否进行trim操作
     * @return 如果为空或者“”，返回true，否则返回false
     */
    public static boolean isEmpty(String value, boolean trimOpr) {
        if (isNull(value)) {
            return true;
        }
        if (trimOpr) {
            return isEmpty(value);
        } else if ("".equals(value)) {
            return true;
        }
        return false;
    }

    /**
     * 为String数组插入指定的分隔符，生成新的数组
     *
     * @param delimit 指定分隔符
     * @param values  给定数组
     * @return 以指定分割符进行拼接后的字符串
     */
    public static String join(String delimit, String[] values) {
        if (values == null || values.length < 1) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String value : values) {
            stringBuffer.append(value).append(delimit);
        }
        return stringBuffer.substring(0, stringBuffer.length() - 1);
    }

    /**
     * 将字符串首字母变大写
     *
     * @param value 待处理字符串
     * @return 首字母大写的字符串
     */
    public static String upperFirstLetter(String value) {
        if (value == null) {
            return null;
        }
        if ("".equals(value)) {
            return "";
        }
        if (value.length() == 1) {
            return value.toUpperCase();
        }
        return value.substring(0, 1).toUpperCase() + value.substring(1);
    }

    /**
     * 下划线转驼峰
     * @param value
     * @return
     */
    public static String underlineToCamel(String value) {
        if (value == null) {
            return null;
        }
        if ("".equals(value)) {
            return "";
        }
        if (!value.contains("_")) {
            return value;
        }
        String[] items = value.split("_");
        StringBuffer sb = new StringBuffer();
        sb.append(items[0]);
        for (int i = 1; i < items.length; i++) {
            sb.append(upperFirstLetter(items[i]));
        }
        return sb.toString();
    }


}
