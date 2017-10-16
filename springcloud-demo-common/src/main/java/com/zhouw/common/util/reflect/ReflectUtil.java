package com.zhouw.common.util.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 反射工具类
 *
 * @author zhouwei
 * @version v1.0
 * @cratedate 2017/6/12.
 * @since v1.0
 */
public class ReflectUtil {


    /**
     * 判断方法是否是静态的
     *
     * @param method 需要验证的方法
     * @return 是否是静态方法
     */
    public static boolean isStaticMethod(Method method) {
        int modifier = method.getModifiers();
        return Modifier.isStatic(modifier);
    }

    /**
     * 执行类的某个方法
     *
     * @param obj            对象
     * @param methodName     方法名
     * @param args           参数
     * @param parameterTypes 参数类型
     * @return 执行结果
     * @throws NoSuchMethodException     NoSuchMethodException
     * @throws InvocationTargetException InvocationTargetException
     * @throws IllegalAccessException    IllegalAccessException
     */
    public static Object exexuteMethod(Object obj, String methodName, Object[] args, Class<?>... parameterTypes)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class clazz = obj.getClass();
        Method method = clazz.getMethod(methodName, parameterTypes);
        return method.invoke(obj, args);
    }

    /**
     * 执行类的静态方法
     *
     * @param clazz          对象
     * @param methodName     方法名
     * @param args           参数
     * @param parameterTypes 参数类型
     * @return 执行结果
     * @throws NoSuchMethodException     NoSuchMethodException
     * @throws InvocationTargetException InvocationTargetException
     * @throws IllegalAccessException    IllegalAccessException
     */
    public static Object exexuteStaticMethod(Class clazz, String methodName, Object[] args, Class<?>... parameterTypes)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = clazz.getMethod(methodName, parameterTypes);
        return method.invoke(null, args);
    }

}
