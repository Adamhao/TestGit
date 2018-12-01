package com.etoak.service.impl;

import com.etoak.bean.Emp;
import com.etoak.mapper.EmpMapper;
import com.etoak.service.EmpService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.security.MessageDigest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Adam on 2018/11/7 16:21.
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Transactional
    @Override
    public void add(Emp emp) {

        Emp temp = empMapper.getEmpByEno(emp.getEno());
        if(temp != null) {
            throw new RuntimeException("员工编号 ( " + emp.getEno() + " ) 已经存在..");
        }

        emp.setHiredate(new Date());
        emp.setPassword(DigestUtils.md5DigestAsHex(emp.getPassword().getBytes()));
        int result = empMapper.add(emp);

        if(result <= 0) {
            throw new RuntimeException("新增员工 (" + emp.getEname() + ") 失败!");
        }
    }

    @Override
    public Emp getEmpByEno(String eno) {
        return empMapper.getEmpByEno(eno);
    }


    @Override
    public Map<String, Object> queryEmpList(Integer pageNumber, Integer pageSize, Emp emp) {

        PageHelper.startPage(pageNumber,pageSize);
        List<Emp> list = empMapper.queryEmpList(emp);

        PageInfo<Emp> pi = new PageInfo<>(list);
        Map<String,Object> map = new HashMap<>();
        map.put("rows",list);
        map.put("total",pi.getTotal());

        return map;
    }

    @Override
    public Emp getEmpById(Integer id) {
        return empMapper.getEmpById(id);
    }

    @Transactional
    @Override
    public void updateEmp(Emp emp) {
        Emp e = empMapper.getEmpById(emp.getId());
        if(e == null) {
            throw new RuntimeException("该员工"+(emp.getEno())+"信息不存在,请刷新列表");
        }
        int result = empMapper.updateEmp(emp);
        if(result != 1) {
            throw new RuntimeException("修改员工信息失败!");
        }
    }

    @Transactional
    @Override
    public void remove(List<Integer> ids) {
        int result = empMapper.remove(ids);
        if(result == 0) {
            throw new RuntimeException("删除用户信息失败..");
        }
    }

    @Transactional
    @Override
    public void updatePwd(Emp emp,String oldPwd,String newPwd) {

        if(emp.getId() == null) {
            throw new RuntimeException("修改失败,刷新页面后重试..");
        }

        Emp temp = empMapper.getEmpById(emp.getId());
        String opwd = DigestUtils.md5DigestAsHex(oldPwd.getBytes());
        if(!temp.getPassword().equals(opwd)) {
            throw new RuntimeException("修改失败,原密码有误.");
        }

        String nPwd = DigestUtils.md5DigestAsHex(newPwd.getBytes());
        emp.setPassword(nPwd);
        int result = empMapper.updatePwd(emp);
        if(result != 1) {
            throw new RuntimeException("修改失败,稍后重试..");
        }
    }

}
