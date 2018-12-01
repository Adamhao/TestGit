package com.etoak.mapper;

import com.etoak.bean.Dept;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Adam on 2018/11/7 14:38.
 */
@Repository
public interface DeptMapper {

    public List<Dept> findDeptByPid(@Param("pid") Integer pid);

}
