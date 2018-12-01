package com.etoak.task;

import com.etoak.bean.User;
import com.etoak.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 待执行的任务
 */
public class Job {

    @Autowired
    private UserMapper userMapper;

    private volatile int count = 0;

    public void taskJob() {

        System.out.println(new Date().toLocaleString());

        int index = count++;

        User user = new User();
        user.setUsername("Adam" + index);
        user.setPassword("sajkldhfkhj");
        userMapper.add(user);

    }

}
