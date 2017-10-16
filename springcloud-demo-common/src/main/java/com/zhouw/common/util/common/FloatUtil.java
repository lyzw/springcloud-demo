package com.zhouw.common.util.common;

/**
 * //TODO {Please input description here }
 *
 * @author zhouwei
 * @version v1.0
 * @cratedate 2017/6/13.
 * @since v1.0
 */
public class FloatUtil {

    public static Float parseToFloat(char[] chars)  {
        if (chars == null) return null;
        String value = new String(chars);
        if (StringUtil.isEmpty(value, true)) {
            return null;
        }
        try{
            return Float.parseFloat(value.trim());
        }catch (Exception e){
            return null;
        }
    }
}
