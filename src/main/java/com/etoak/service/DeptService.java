package com.etoak.service;

import com.etoak.util.TreeNode;

import java.util.List;

/**
 * Created by Adam on 2018/11/7 14:45.
 */
public interface DeptService {

    public List<TreeNode> findDeptByPid(Integer pid);

}
