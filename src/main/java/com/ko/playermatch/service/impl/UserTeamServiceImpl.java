package com.ko.playermatch.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ko.playermatch.mapper.UserTeamMapper;
import com.ko.playermatch.model.domain.UserTeam;
import com.ko.playermatch.service.UserTeamService;
import org.springframework.stereotype.Service;

/**
* @author 15835
* @description 针对表【user_team(用户队伍关系)】的数据库操作Service实现
* @createDate 2023-06-29 02:21:10
*/
@Service
public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeam>
    implements UserTeamService {

}




