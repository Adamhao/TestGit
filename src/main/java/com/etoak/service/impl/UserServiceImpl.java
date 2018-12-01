package com.etoak.service.impl;

import com.etoak.bean.Emp;
import com.etoak.util.JsonUtil;
import com.etoak.util.ResultMsg;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import com.etoak.bean.User;
import com.etoak.mapper.UserMapper;
import com.etoak.service.UserService;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebService;
import java.util.List;

@WebService
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper mapper;
	
	@Transactional
	@Override
	public void add(User user) {
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		int result = mapper.add(user);
		if(result <= 0) {
			throw new RuntimeException("新增用户 " + user.getUsername() + " 失败!");
		}
	}

    @Override
    public String save(User user) {
	    String result = null;
	    if(user == null) {
            result = JsonUtil.toStr(new ResultMsg(500,"输入信息为空"));
            return result;
        }
        if(user.getUsername() == null || user.getUsername().trim().length() == 0) {
	        result = JsonUtil.toStr(new ResultMsg(500,"用户名为空"));
	        return result;
        }
        if(user.getPassword() == null || user.getPassword().length() == 0) {
	        result = JsonUtil.toStr(new ResultMsg(500,"密码为空"));
	        return result;
        }

        int count = mapper.isUsernameExists(user.getUsername());
	    if(count != 0) {
	        result = JsonUtil.toStr(new ResultMsg(500,"用户名已存在"));
	        return result;
        }

        //受影响的行数
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        int row = mapper.add(user);
	    if(row != 1) {
	        result = JsonUtil.toStr(new ResultMsg(500,"用户添加失败"));
	        return result;
        }
        return JsonUtil.toStr(new ResultMsg(200,"添加成功"));
    }

    @Override
    public String update(User user) {
        return null;
    }

    @ResponseBody
    @Override
    public List<User> getAll(Integer pageNumber,Integer pageSize,Emp emp) {
        if(pageNumber == null) {
            pageNumber = 1;
        }
        if(pageSize == null) {
            pageSize = 10;
        }
        if(pageSize >= 100) {
            pageSize = 100;
        }

        PageHelper.startPage(pageNumber,pageSize);
        List<User> list = mapper.queryPage();

        return list;
    }

    @Override
    public String del(Integer id) {
        return null;
    }

}
