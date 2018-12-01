<%--
  Created by IntelliJ IDEA.
  User: Adam
  Date: 2018/11/7
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>query</title>
    </head>
    <body>
        <table style="margin: 20px auto;" cellspacing="2px" cellpadding="2px">
            <tr>
                <td>员工姓名</td>
                <td><input id="ename" class="easyui-textbox" data-options="
                    width:180" name="ename" /></td>
            </tr>

            <tr>
                <td>所在部门</td>
                <td>
                    <input id="did" name="did" class="easyui-combotree" data-options="
                    width:180,
                    url:'${pageContext.request.contextPath}/dept/getDept',
                    animate:true,lines:true"/>
                </td>
            </tr>

            <tr>
                <td>开始时间(入职)</td>
                <td><input id="startTime" class="easyui-datebox" data-options="
                    width:180" name="startTime" /></td>
            </tr>

            <tr>
                <td>结束时间(入职)</td>
                <td><input id="endTime" class="easyui-datebox" data-options="
                    width:180" name="endTime" /></td>
            </tr>

        </table>
    </body>
</html>
