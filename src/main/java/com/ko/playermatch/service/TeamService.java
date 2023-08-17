package com.ko.playermatch.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ko.playermatch.model.domain.Team;
import com.ko.playermatch.model.domain.User;
import com.ko.playermatch.model.dto.TeamQuery;
import com.ko.playermatch.model.request.TeamJoinRequest;
import com.ko.playermatch.model.request.TeamQuitRequest;
import com.ko.playermatch.model.request.TeamUpdateRequest;
import com.ko.playermatch.model.vo.TeamUserVO;

import java.util.List;


public interface TeamService extends IService<Team> {

    /**
     * 创建队伍
     * @param team
     * @param loginUser
     * @return
     */
    long addTeam(Team team, User loginUser);

    /**
     * 搜索队伍
     * @param teamQuery
     * @return
     */
    List<TeamUserVO> listTeams(TeamQuery teamQuery,boolean isAdmin);

    /**
     * 更新队伍
     * @param teamUpdateRequest
     * @return
     */
    boolean updateTeam(TeamUpdateRequest teamUpdateRequest, User loginUser);

    /**
     * 加入队伍
     * @param teamJoinRequest
     * @return
     */
    boolean joinTeam(TeamJoinRequest teamJoinRequest, User loginUser);

    /**
     * 退出队伍
     * @param teamQuitRequest
     * @param loginUser
     * @return
     */
    boolean quitTeam(TeamQuitRequest teamQuitRequest, User loginUser);

    /**
     * 删除解散队伍
     * @param id
     * @return
     */
    boolean deleteTeam(long id, User loginUser);
}
