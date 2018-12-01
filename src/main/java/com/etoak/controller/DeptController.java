package com.etoak.controller;

import com.etoak.service.DeptService;
import com.etoak.util.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Adam on 2018/11/7 15:01.
 */
@Controller
@RequestMapping(value = "/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/getDept",method = RequestMethod.POST)
    @ResponseBody
    public List<TreeNode> getDept(
            @RequestParam(value="id",defaultValue = "0") Integer id) {
        return deptService.findDeptByPid(id);
    }
}
