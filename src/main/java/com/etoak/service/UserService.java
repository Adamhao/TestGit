package com.etoak.service;

import com.etoak.bean.Emp;
import com.etoak.bean.User;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface UserService {
	
	void add(User user);

	String save(User user);

    String update(User user);

    List<User> getAll(Integer pageNumber,Integer pageSize,Emp emp);

    String del(Integer id);
}
