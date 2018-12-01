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

        <a href="#" id="btn"></a>
        <script>
            $(function () {
                $("#btn").linkbutton({
                    toggle : true,
                    iconCls : "icon-search",
                    onClick : function () {
                        alert("icon-search");
                    }
                });
                console.log($("#btn").css("select"));
            });
        </script>
    </body>
</html>
