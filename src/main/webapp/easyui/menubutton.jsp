<%--
  Created by IntelliJ IDEA.
  User: Adam
  Date: 2018/11/6
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <%@include file="/easyui/include.jsp" %>
    </head>
    <body>
        <a id="mb" href="javascript:void(0);">这是一个按钮</a>
        <div id="menu" style="width: 150px;">
            <div data-options="iconCls:'icon-undo'">Undo</div>
            <div data-options="iconCls:'icon-redo'">Redo</div>
            <div class="menu-sep"></div>
            <div>Cut</div>
            <div>Copy</div>
            <div>Paste</div>
            <div class="menu-sep"></div>
            <div data-options="iconCls:'icon-remove'">Delete</div>
            <div>Select All</div>
        </div>

        <script>
            $(function () {
                $("#mb").menubutton({
                    iconCls : "icon-edit",
                    menu : "#menu"
                });
                $("#menu").menu({
                    noline : true
                });
            });
        </script>
    </body>
</html>
