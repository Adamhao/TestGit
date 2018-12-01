<%--
  Created by IntelliJ IDEA.
  User: Adam
  Date: 2018/11/9
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>修改密码</title>
    </head>
    <body>
        <form id="changePwd-form" method="post">
            <table style="margin: 20px auto;">
                <tr>
                    <td>原密码</td>
                    <td><input id="opwd" class="easyui-textbox" data-options="
                            required:true,width:180,type:'password'" name="oldPwd"/></td>
                </tr>
                <tr>
                    <td>新密码</td>
                    <td><input id="pwd" class="easyui-textbox" data-options="
                            required:true,width:180,type:'password'" name="newPwd"/></td>
                </tr>
                <tr>
                    <td>确认密码</td>
                    <td><input id="rpwd" class="easyui-textbox" data-options="
                            required:true,width:180,type:'password'"
                               validType="check['#pwd']"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>