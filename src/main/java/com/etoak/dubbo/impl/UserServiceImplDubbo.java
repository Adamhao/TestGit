package com.etoak.dubbo.impl;

import com.etoak.bean.User;
import com.etoak.dubbo.UserServiceDubbo;
import com.etoak.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Adam on 2018/11/14 10:00.
 */
public class UserServiceImplDubbo implements UserServiceDubbo{

    @Autowired
    private UserMapper userMapper;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public String add(User user) {

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int result = userMapper.add(user);
        if(result ==0 ) {
            return "{\"flag\":\"error\",\"msg\",\"新增失败\"}";
        }
        return "{\"flag\":\"success\",\"msg\",\"新增成功\"}";
    }

}
