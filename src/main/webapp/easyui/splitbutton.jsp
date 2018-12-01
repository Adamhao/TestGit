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
        <a id="sb" href="javascript:void(0);" onclick="alert('i am fine!!')"> Ready </a>
        <div id="mm" style="width:100px;">
            <div data-options="iconCls:'icon-ok'">Ok</div>
            <div data-options="iconCls:'icon-cancel'">Cancel</div>
        </div>

        <script>
            $(function () {
                $("#sb").splitbutton({
                    iconCls : "icon-ok",
                    menu : "#mm"
                });
            });
        </script>
    </body>
</html>
