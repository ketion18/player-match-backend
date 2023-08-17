package com.ko.playermatch.model.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class TeamJoinRequest implements Serializable {

    private static final long serialVersionUID = 7494713532566233935L;

    /**
     * id
     */
    private Long teamId;
    
        /**
     * 密码
     */
    private String password;
    

}
