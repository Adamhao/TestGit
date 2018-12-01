package com.etoak.controller;

import com.etoak.bean.Emp;
import com.etoak.service.EmpService;
import com.etoak.util.ResultMsg;
import com.etoak.util.TreeNode;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Adam on 2018/11/7 10:17.
 */
@Controller
@RequestMapping(value = "/emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    @RequestMapping(value = "/empAddAndUpdate",method = RequestMethod.GET)
    public String empAddAndUpdate(Integer id,Model m) {
        if(id != null) {
            Emp e = empService.getEmpById(id);
            m.addAttribute("e",e);
        }
        return "emp/addAndUpdate";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg add(Emp emp) {

        try {
            empService.add(emp);
            return new ResultMsg(200,"新增员工" + emp.getEname() + "成功!");
        } catch (Exception e) {
            return new ResultMsg(500,e.getMessage());
        }
    }

    //跳转员工列表页面
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list() {
        return "emp/list";
    }


    @RequestMapping(value = "/queryEmpList",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> queryEmpList(
           @RequestParam("page") Integer pageNumber,
           @RequestParam("rows") Integer pageSize,Emp emp) {

        return empService.queryEmpList(pageNumber,pageSize,emp);
    }

    @RequestMapping(value = "/updateEmp",method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg updateEmp(Emp emp) {
        try {
            empService.updateEmp(emp);
            return new ResultMsg(200,"更新员工信息成功");
        } catch (Exception e) {
            return new ResultMsg(500,e.getMessage());
        }
    }

    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg remove(@RequestBody List<Integer> ids) {
        if(ids == null || ids.isEmpty()) {
            return new ResultMsg(500,"删除信息失败");
        }

        try {
            empService.remove(ids);
            return new ResultMsg(200,"成功删除" + ids.size() + "条员工信息");
        } catch (Exception e) {
            return new ResultMsg(500,e.getMessage());
        }
    }

    @RequestMapping(value = "/getChangePwdPage",method = RequestMethod.GET)
    public String getChangePwdPage() {
        return "emp/changePwd";
    }

    @RequestMapping(value = "/changePwd",method = RequestMethod.POST)
    @ResponseBody
    public ResultMsg changPwd(String oldPwd, String newPwd, HttpSession session) {
        Emp emp = (Emp) session.getAttribute("emp");
        if(oldPwd == null || newPwd == null) {
            return new ResultMsg(500,"请按要求填写信息");
        }

        try {
            empService.updatePwd(emp,oldPwd,newPwd);
            session.invalidate();
            return new ResultMsg(200,"修改密码成功");
        } catch (Exception e) {
            return new ResultMsg(500,e.getMessage());
        }

    }
}
