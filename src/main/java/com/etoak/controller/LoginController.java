package com.etoak.controller;

import com.etoak.bean.Emp;
import com.etoak.service.EmpService;
import com.etoak.util.ResultMsg;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Adam on 2018/11/7 17:53.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private EmpService empService;

    @RequestMapping(value = "/login")
    @ResponseBody
    public ResultMsg login(String username, String password, HttpSession session) {

        //loginEmp();
        return loginShiro(username,password,session);
    }

    private ResultMsg loginEmp(String username, String password, HttpSession session) {

        if(username == null || username.trim().length() == 0 || password == null) {
            return new ResultMsg(500,"用户名为空.");
        }

        Emp emp = empService.getEmpByEno(username);
        if(emp == null) {
            return new ResultMsg(500,"该用户名(" + username + ")不存在.");
        }

        password = DigestUtils.md5DigestAsHex(password.getBytes());

        if(!emp.getPassword().equals(password)) {
            return new ResultMsg(500,"密码错误");
        }

        emp.setPassword(null);
        session.setAttribute("emp",emp);

        return new ResultMsg(200,"-登录成功-");

    }

    private ResultMsg loginShiro(String username,String password,HttpSession session) {

        Subject subject = SecurityUtils.getSubject();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        try {
            subject.login(token);

            token.setRememberMe(true);
            boolean result = subject.isAuthenticated();
            if(result) {
                Session s = subject.getSession();
                Emp emp = (Emp) subject.getPrincipal();
                s.setAttribute("emp",emp);
                //session.setAttribute("emp",emp);
                return new ResultMsg(200,"登陆成功");
            } else {
                return new ResultMsg(500,"登陆失败");
            }
        } catch (UnknownAccountException | IncorrectCredentialsException e) {
            return new ResultMsg(500,e.getMessage());
        } catch (Exception e) {
            return new ResultMsg(500,e.getMessage());
        }

    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpSession session) {
        //session.invalidate();
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/";
    }
}
