package com.ko.playermatch.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用删除请求
 */
@Data
public class DeleteRequest implements Serializable {
    //序列化id,使对象在序列化的时候保持唯一
    private static final long serialVersionUID = 5260088427577967753L;

    
    private long id;

}
