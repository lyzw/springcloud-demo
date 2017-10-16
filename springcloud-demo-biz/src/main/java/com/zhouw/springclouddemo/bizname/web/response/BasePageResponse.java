package com.zhouw.springclouddemo.bizname.web.response;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.zhouw.springclouddemo.bizname.constant.RetCodeContants;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * //TODO {Please input description here }
 *
 * @author zhouwei
 * @version v1.0
 * @cratedate 2017/9/11.
 * @since v1.0
 */
@Setter
@Getter
public class BasePageResponse extends BaseResponse {

    //分页信息
    private PageInfo page;

    public static BasePageResponse success(List data, PageInfo pageInfo) {
        BasePageResponse basePageResponse = new BasePageResponse();
        basePageResponse.setPage(pageInfo);
        return basePageResponse;
    }

    public static BasePageResponse fail(String code, String message) {
        BasePageResponse basePageResponse = new BasePageResponse();
        basePageResponse.setPage(PageInfo.empty());
        basePageResponse.setRetCode(code);
        basePageResponse.setRetMessage(message);
        return basePageResponse;
    }

    public static BasePageResponse error() {
        return fail(RetCodeContants.RET_CODE_SYS_ERROR, RetCodeContants.RET_MSG_SYS_ERROR);
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(error(), SerializerFeature.WriteNullStringAsEmpty));
    }

}
