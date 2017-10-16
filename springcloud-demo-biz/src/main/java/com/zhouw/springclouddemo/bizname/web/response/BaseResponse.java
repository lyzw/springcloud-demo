package com.zhouw.springclouddemo.bizname.web.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.zhouw.springclouddemo.bizname.constant.RetCodeContants;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * 数据返回模板，可继承此类做一定的扩展
 *
 * @author zhouwei
 * @version v1.0
 * @cratedate 2017/9/11.
 * @since v1.0
 */
@Getter
@Setter
public class BaseResponse {

    //返回码
    private String retCode;
    //返回信息
    private String retMessage;
    //返回数据
    private Object data;
    //返回时间
    @JSONField(format = "yyyyMMddHHmmssSSS") private Date retTime = new Date();

    /**
     * 成功的返回
     *
     * @param data 数据
     * @return 反馈
     */
    public static BaseResponse success(Object data) {
        BaseResponse response = new BaseResponse();
        response.setRetCode(RetCodeContants.RET_CODE_SUCCESS);
        response.setRetMessage(RetCodeContants.RET_MSG_SUCCESS);
        response.setData(data);
        return response;
    }

    /**
     * 失败的返回
     *
     * @param code    返回码
     * @param message 返回信息
     * @return 反馈
     */
    public static BaseResponse fail(String code, String message) {
        BaseResponse response = new BaseResponse();
        response.setRetCode(code);
        response.setRetMessage(message);
        return response;
    }

    /**
     * 异常的返回
     *
     * @return 反馈
     */
    public static BaseResponse error() {
        return fail(RetCodeContants.RET_CODE_SYS_ERROR, RetCodeContants.RET_CODE_SYS_ERROR);
    }

    /**
     * 异常的返回
     *
     * @param message 需要返回的信息
     * @return 反馈
     */
    public static BaseResponse error(String message) {
        return fail(RetCodeContants.RET_CODE_SYS_ERROR, message);
    }
}
