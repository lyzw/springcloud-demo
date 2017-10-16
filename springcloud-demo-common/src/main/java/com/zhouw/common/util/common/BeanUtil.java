package com.zhouw.common.util.common;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Bean工具类
 *
 * @author zhouwei
 * @version v1.0
 * @cratedate 2017/9/21.
 * @since v1.0
 */
public class BeanUtil {

    /**
     * 将Bean转换为工具类
     *
     * @param object Bean实体类
     * @return 转换后的map
     * @throws IllegalAccessException 无访问权限
     */
    public static Map<String, Object> transBeanToMap(Object object) throws IllegalAccessException {
        Map<String, Object> retMap = new HashMap();
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            //判断是否是transient类型，若是transient类型的数据则不需要转换为map
            if (!Modifier.isTransient(field.getModifiers())) {
                retMap.put(field.getName(), field.get(object));
            }
        }
        return retMap;
    }

    /**
     * 将Map转换为实体Bean
     *
     * @param clazz    类
     * @param valueMap 对应的map
     * @return 转化后的Bean
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static Object transMapToBean(Class clazz, Map<String, Object> valueMap)
            throws IllegalAccessException, InstantiationException {
        Object object = clazz.newInstance();
        Set<String> keys = valueMap.keySet();
        for (String key : keys) {
            try {
                Field field = clazz.getField(key);
                if (field != null) {
                    field.setAccessible(true);
                }
                field.set(object,valueMap.get(key));
            } catch (NoSuchFieldException e) {
                //没有此属性，有可能是使用的是set方法赋值
                e.printStackTrace();
                String methodeName = "set" + StringUtil.upperFirstLetter(key);
                try {
                    Method method = clazz.getMethod(methodeName,valueMap.get(key).getClass());
                    method.invoke(object,valueMap.get(key));
                } catch (NoSuchMethodException e1) {
                    e1.printStackTrace();
                } catch (InvocationTargetException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return object;
    }

}
