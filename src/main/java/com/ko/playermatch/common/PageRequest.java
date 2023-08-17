package com.ko.playermatch.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用分页请求参数
 */
@Data
public class PageRequest implements Serializable {
    //序列化id,使对象在序列化的时候保持唯一
    private static final long serialVersionUID = 5260088427577967753L;
    
    /**
     * 页面大小
     */
    protected int pageSize = 10;

    /**
     * 当前是第几页
     */
    protected int pageNum = 1;

}
