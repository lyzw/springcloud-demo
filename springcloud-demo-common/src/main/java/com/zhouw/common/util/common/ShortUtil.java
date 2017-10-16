package com.zhouw.common.util.common;

/**
 * //TODO {Please input description here }
 *
 * @author zhouwei
 * @version v1.0
 * @cratedate 2017/6/14.
 * @since v1.0
 */
public class ShortUtil {


    public static Short parseToShort(char[] chars)  {
        if (chars == null) return null;
        String value = new String(chars);
        if (StringUtil.isEmpty(value, true)) {
            return null;
        }
        try{
            return Short.parseShort(value.trim());
        }catch (Exception e){
            return null;
        }
    }
}
