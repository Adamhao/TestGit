package com.etoak.mapper;

import com.etoak.bean.Emp;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Adam on 2018/11/7 16:13.
 */
@Repository
public interface EmpMapper {

    public int add(Emp emp);

    public Emp getEmpByEno(@Param("eno") String eno);

    public List<Emp> queryEmpList(Emp emp);

    public Emp getEmpById(Integer id);

    public int updateEmp(Emp emp);

    public int remove(List<Integer> ids);

    public int updatePwd(Emp emp);
}
