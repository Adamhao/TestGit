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
        <input class="easyui-switchbutton" checked>
        <input class="easyui-switchbutton" data-options="onText:'Yes',offText:'No'">
        <input class="easyui-switchbutton" data-options="onText:'是',offText:'否'">

        <hr>

        <input type="text" id="sb" style="width:200px; height: 30px;">
        <script>
            $(function() {
                $("#sb").switchbutton({
                    onText : "是",
                    offText : "否",
                    handleText : "...."
                });
            });
        </script>
    </body>
</html>
