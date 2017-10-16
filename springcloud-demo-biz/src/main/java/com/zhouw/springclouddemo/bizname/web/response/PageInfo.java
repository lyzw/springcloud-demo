package com.zhouw.springclouddemo.bizname.web.response;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * 分页信息
 *
 * @author zhouwei
 * @version v1.0
 * @cratedate 2017/9/11.
 * @since v1.0
 */
@Getter
@Setter
public class PageInfo implements Serializable {


    //当前页码
    private int currentPage = 1;
    //总页数
    private int totalPage = 0;
    //每页记录数
    private int pageSize = 20;
    //总数
    private long total = 0;

    public PageInfo() {
    }

    /**
     * @param currentPage 当前页码
     * @param totalPage   总页数
     * @param pageSize    每页记录数
     * @param total       总记录数
     */
    public PageInfo(int currentPage, int totalPage, int pageSize, long total) {
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.pageSize = pageSize;
        this.total = total;
    }

    /**
     * 默认“每页记录”下无数据时候的分页信息
     *
     * @return 无数据时候的分页信息
     */
    public static PageInfo empty() {
        return new PageInfo();
    }

    /**
     * 给定“每页记录”下无数据时候的分页信息
     *
     * @param pageSize 给定的每页记录数
     * @return 无数据时候的分页信息
     */
    public static PageInfo empty(int pageSize) {
        return new PageInfo();
    }


}
