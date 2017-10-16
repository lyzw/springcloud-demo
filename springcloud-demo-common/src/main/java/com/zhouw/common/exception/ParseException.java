package com.zhouw.common.exception;


import com.zhouw.common.util.common.StringUtil;

/**
 * 类型转换异常
 *
 * @author zhouwei
 * @version v1.0
 * @cratedate 2017/5/27.
 * @since v1.0
 */
public class ParseException extends Exception {

    /**
     * 错误码
     */
    private String code;
    /**
     * 错误描述
     */
    private String message;

    /**
     * 构造方法
     *
     * @param code    错误编码
     * @param message 错误消息
     */
    public ParseException(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    /**
     * 无参构造方法
     */
    public ParseException() {
        super();
    }

    /**
     * 获取字符转数字类型转换异常
     *
     * @param code    错误码
     * @param message 错误描述
     * @return 字符转数字类型转换异常
     */
    public static ParseException intgerParseNullException(String code, String message) {
        String errCode = StringUtil.isEmpty(code) ? "" : code;
        String errMsg = StringUtil.isEmpty(message) ? "" : message;
        return new ParseException(errCode, errMsg);
    }

    /**
     * 获取字符转数字类型转换异常
     *
     * @param code    错误码
     * @param message 错误描述
     * @return 字符转数字类型转换异常
     */
    public static ParseException intgerParseEmptyException(String code, String message) {
        String errCode = StringUtil.isEmpty(code) ? "" : code;
        String errMsg = StringUtil.isEmpty(message) ? "" : message;
        return new ParseException(errCode, errMsg);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
