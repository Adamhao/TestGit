package com.etoak.controller;

import java.util.HashMap;
import java.util.Map;

import com.etoak.util.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etoak.bean.User;
import com.etoak.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/add")
	@ResponseBody
	public Map<String,Object> add(User user) {
		
		Map<String,Object> result = new HashMap<>();
		
		try {
			userService.add(user);
			result.put("flag", "success");
			result.put("msg", "新增用户 " + user.getUsername() + " 成功! ");
		} catch(Exception e) {
			result.put("flag", "error");
			result.put("msg", e.getMessage());
		}
		
		return result;
	}

	@RequestMapping(value = "/testJson")
    @ResponseBody
	public ResultMsg testJson(@RequestBody Map<String,Object> map,String xml) {

        System.out.println(map.get("username"));
        System.out.println(map.get("password"));
        return new ResultMsg(200,"接收json数据成功");
    }

    @RequestMapping(value = "/testXml")
    @ResponseBody
    public ResultMsg testXml(@RequestBody String xml) {

        System.out.println(xml);
        return new ResultMsg(200,"接收xml数据成功");
    }
	
	
}
