package com.zhouw.common.util.collections;



import com.zhouw.common.exception.ParseException;
import com.zhouw.common.util.common.IntegerUtil;
import com.zhouw.common.util.reflect.ReflectUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Map工具类
 *
 * @author zhouwei
 * @version v1.0
 * @cratedate 2017/6/13.
 * @since v1.0
 */
public class MapUtil {


    /**
     * 将list转换为map，暂时只是支持将返回类型为String，且有无参的获取方法作为key，一般用于包含get方法的bean类
     *
     * @param list       对象list
     * @param methodName 获取key的方法名
     * @return 转换后的map
     * @throws NoSuchMethodException     无此方法错误
     * @throws IllegalAccessException    访问错误
     * @throws InvocationTargetException 反射错误
     */
    public static Map transferListToMap(List list, String methodName)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Map map = new HashMap();
        for (Object object : list) {
            String key = (String) ReflectUtil.exexuteMethod(object, methodName, null, null);
            map.put(key, object);
        }
        return map;
    }


    /**
     * 获取map的值
     *
     * @param map 目标map
     * @param key 目标key
     * @return map中key对应的值
     */
    public Object getValue(Map map, String key) {
        if (map == null) {
            return null;
        }
        return map.get(key);
    }

    /**
     * 获取map中的整形数据
     *
     * @param map map
     * @param key 键值
     * @return 获取的整形数据
     * @throws ParseException 转换异常
     */
    public Integer getIntegerValue(Map map, String key) throws ParseException {
        //如果map为空，直接返回null
        if (map == null) {
            return null;
        }
        //如果不包含对应的key
        if (map.get(key) == null) {
            return null;
        }
        Object value = map.get(key);
        //如果对应的类型是Integer，则直接返回
        if (value instanceof Integer) {
            return (Integer) map.get(key);
            //如果对应的key是字符串，尝试转换成数字
        } else if (value instanceof String) {
            return IntegerUtil.parseToInteger((String) value);
            //其他的类型，则先尝试转换成String，再进行类型的转换
        } else {
            try {
                String strValue = String.valueOf(value);
                return IntegerUtil.parseToInteger(strValue);
            } catch (Exception e) {
                return null;
            }
        }
    }
}
