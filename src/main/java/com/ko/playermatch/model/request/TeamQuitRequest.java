package com.ko.playermatch.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户退出队伍请求体
 */
@Data
public class TeamQuitRequest implements Serializable {

    private static final long serialVersionUID = 7494713532566233935L;

    /**
     * id
     */
    private Long teamId;
    

}
