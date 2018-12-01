package com.etoak.service.impl;

import com.etoak.bean.Dept;
import com.etoak.mapper.DeptMapper;
import com.etoak.service.DeptService;
import com.etoak.util.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 2018/11/7 14:46.
 */
@Service
public class DeptServiceImpl implements DeptService{

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<TreeNode> findDeptByPid(Integer pid) {

        List<Dept> list = deptMapper.findDeptByPid(pid);
        if(list == null || list.isEmpty()) {
            return null;
        }
        List<TreeNode> result = new ArrayList<>();
        TreeNode treeNode = null;
        for(Dept d : list) {
            treeNode = new TreeNode();
            treeNode.setId(d.getId());
            treeNode.setText(d.getDname());
            if(pid == 0) {
                treeNode.setIconCls("icon-filter");
            }else {
                treeNode.setIconCls("icon-man");
            }
            List<Dept> childrenList = deptMapper.findDeptByPid(d.getId());
            treeNode.setState(childrenList == null || childrenList.isEmpty()?"open":"closed");
            result.add(treeNode);
        }

        return result;
    }
}
