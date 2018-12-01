package com.etoak.shiro;

import com.etoak.bean.Emp;
import com.etoak.service.EmpService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Adam on 2018/11/10 15:15.
 */
public class MyRealm extends AuthorizingRealm{

    @Autowired
    private EmpService empService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {

        Emp emp = (Emp) principal.getPrimaryPrincipal();

        SimpleAuthorizationInfo sai = new SimpleAuthorizationInfo();

        Set<String> roles = new HashSet<>();
        roles.add("VIP1");
        roles.add("VIP2");
        sai.setRoles(roles);

        Set<String> permissions = new HashSet<>();
        permissions.add("VIP1:opts");
        permissions.add("VIP2:opts");
        sai.setStringPermissions(permissions);

        return sai;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        String username = token.getUsername();
        String password = new String(token.getPassword());
        System.out.println(token.getCredentials());

        Emp emp = empService.getEmpByEno(username);
        if(emp == null) {
            throw new UnknownAccountException("未知用户信息");
        }

        SimpleAuthenticationInfo sai = new SimpleAuthenticationInfo(emp,emp.getPassword(),this.getName());


        return sai;
    }
}
