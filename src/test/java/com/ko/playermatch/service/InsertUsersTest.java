package com.ko.playermatch.service;

import com.ko.playermatch.model.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@SpringBootTest
public class InsertUsersTest {

    @Resource
    private UserService userService;

    /**
     * 批量插入用户
     */
//    @Test
//    public void doInsertUsers() {
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.start();
//        final int INSERT_NUM = 500;
//        List<User> userList = new ArrayList<>();
//        for (int i = 0; i < INSERT_NUM; i++) {
//            User user = new User();
//            user.setUsername("ketion");
//            user.setUserAccount("ketion");
//            user.setAvatarUrl("https://img1.baidu.com/it/u=880756514,4066119905&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=518");
//            user.setGender(0);
//            user.setUserPassword("12345678");
//            user.setPhone("12345678901");
//            user.setEmail("123@qq.com");
//            user.setTags("[]");
//            user.setProfile("");
//            user.setUserStatus(0);
//            user.setUserRole(0);
//            user.setPlanetCode("45");
//            userList.add(user);
//        }
//        userService.saveBatch(userList, 100);
//        stopWatch.stop();
//        System.out.println(stopWatch.getTotalTimeMillis());
//    }
//
    /**
     * 多线程批量插入数据
     */
    @Test
    public void doConcurrencyInsertUsers() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final int INSERT_NUM = 100000;
        //分10组
        int j = 0;
        List<CompletableFuture<Void>> futureList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<User> userList = new ArrayList<>();
            while (true) {
                j++;
                User user = new User();
                user.setUsername("rookie");
                user.setUserAccount("keke");
                user.setAvatarUrl("https://img2.baidu.com/it/u=231978864,1916820013&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500");
                user.setGender(1);
                user.setUserPassword("12345678");
                user.setPhone("12345678901");
                user.setEmail("123@qq.com");
                user.setTags("[]");
                user.setProfile("不知名新秀");
                user.setUserStatus(0);
                user.setUserRole(0);
                user.setPlanetCode("00");
                userList.add(user);
                if (j % 10000 == 0) {
                    break;
                }
            }
            //异步执行
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                System.out.println("threadName" + Thread.currentThread().getName());
                userService.saveBatch(userList, 10000);
            });
            futureList.add(future);
        }
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[]{})).join();
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }
}
