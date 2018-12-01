package com.etoak.service;

import com.etoak.bean.Emp;

import java.util.List;
import java.util.Map;

/**
 * Created by Adam on 2018/11/7 16:11.
 */
public interface EmpService {

    public void add(Emp emp);

    public Emp getEmpByEno(String eno);

    public Map<String,Object> queryEmpList(Integer pageNumber,Integer pageSize,Emp emp);

    public Emp getEmpById(Integer id);

    public void updateEmp(Emp emp);

    public void remove(List<Integer> ids);

    public void updatePwd(Emp emp,String oldPwd,String newPwd);
}
