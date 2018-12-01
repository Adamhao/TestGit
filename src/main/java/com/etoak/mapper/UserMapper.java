package com.etoak.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.etoak.bean.User;

@Repository
public interface UserMapper {
	
	public int add(User user);
	
	public List<User> queryPage();
	
	public int update(User user);
	
	public int delete(Integer id);

	int isUsernameExists(@Param("username") String username);
}
