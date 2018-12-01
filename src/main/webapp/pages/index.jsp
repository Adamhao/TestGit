<%--
  Created by IntelliJ IDEA.
  User: Adam
  Date: 2018/11/8
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
    <head>
        <title>首页</title>
        <%@include file="/easyui/include.jsp"%>
        <script src="${pageContext.request.contextPath}/js/index.js"></script>
    </head>
    <body>

        <div class="easyui-layout" data-options="fit:true">
            <div data-options="region:'north',collapsible:false,height:100">
                <div style="float: right;margin-right: 50px;height: 90px;line-height: 98px;font-size: 20px">
                    <span>欢迎:<span style="color: #0E2D5F">${emp.ename}</span></span>
                    <span><a href="javascript:void(0);" onclick="changePwd()">修改密码</a></span>
                    <span>
                        <a href="javascript:void(0);" onclick="logout()">退出</a>
                    </span>
                </div>
            </div>
            <div data-options="region:'west',title:'菜单栏',width:200,split:true">

                <div id="aa" class="easyui-accordion" data-options="fit:true">
                    <div title="系统权限">
                        <ul class="easyui-tree">
                            <li><a class="opts" href="javascript:void(0);">用户权限</a></li>
                            <li><a class="opts" href="javascript:void(0);">角色权限</a></li>
                            <li><a class="opts" href="javascript:void(0);">访问权限</a></li>
                        </ul>
                    </div>
                    <div title="员工管理">
                        <ul class="easyui-tree">
                            <li><a class="opts" href="javascript:void(0);" url="/emp/list">员工入职</a></li>
                        </ul>
                    </div>
                    <shiro:hasRole name="VIP1">
                        <div title="部门管理">
                            content3
                        </div>
                    </shiro:hasRole>
                    <shiro:hasRole name="VIP2">
                        <div title="测试角色">
                            content4
                        </div>
                    </shiro:hasRole>

                    <shiro:hasPermission name="VIP3:opts">
                        <div title="测试权限">
                            content 5
                        </div>
                    </shiro:hasPermission>

                </div>

            </div>

            <div data-options="region:'center',split:true">
                <div id="content" class="easyui-tabs" data-options="fit:true,pill:true">
                </div>
            </div>
        </div>

        <div id="pwd-dialog"></div>

    </body>
</html>
