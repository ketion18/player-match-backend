package com.ko.playermatch.once;
import java.util.Date;

import com.ko.playermatch.mapper.UserMapper;
import com.ko.playermatch.model.domain.User;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;

@Component
public class InsertUsers {
    
    @Resource
    private UserMapper userMapper;

    /**
     * 批量插入用户
     */
    public void doInsertUsers() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final int INSERT_NUM = 10000000;
        for (int i = 0; i < INSERT_NUM; i++) {
            User user = new User();
            user.setUsername("假用户");
            user.setUserAccount("fakeko");
            user.setAvatarUrl("https://p2.ssl.qhimgs1.com/sdr/400__/t03c2244f41ff6a4a3c.jpg");
            user.setGender(0);
            user.setUserPassword("12345678");
            user.setPhone("12345678901");
            user.setEmail("123@qq.com");
            user.setTags("[]");
            user.setProfile("");
            user.setUserStatus(0);
            user.setUserRole(0);
            user.setPlanetCode("4");
            userMapper.insert(user);
        }
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }
    
}
