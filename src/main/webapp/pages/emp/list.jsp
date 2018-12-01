<%--
  Created by IntelliJ IDEA.
  User: Adam
  Date: 2018/11/8
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>员工列表</title>
        <%@include file="/easyui/include.jsp"%>
        <script src="${pageContext.request.contextPath}/js/emp/list.js"></script>
    </head>
    <body>
        <table id="emp-list"></table>

        <%--员工列表 工具栏--%>
        <div id="emp-list-toolbar">
            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
               onclick="eventObj.query();">查询</a>

            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-add'"
               onclick="eventObj.add()">新增</a>

            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-edit'"
               onclick="eventObj.update()">修改</a>

            <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-remove'"
               onclick="eventObj.remove()">删除</a>
        </div>

        <%--操作窗口--%>
        <div id="emp-dialog">

        </div>
    </body>
</html>
