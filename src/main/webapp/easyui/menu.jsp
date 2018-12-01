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
        <div id="menu">
            <div>New</div>
            <div>
                <span>open</span>
                <div>
                    <div>Word</div>
                    <div>Excel</div>
                    <div>PowerPoint</div>
                </div>
            </div>
            <div data-options="iconCls:'icon-save'" onclick="save()">save</div>
            <div class="menu-sep"></div>
            <div>exit</div>
        </div>


        <script>
            $(function () {
                $("#menu").menu({
                    iconCls : "icon-ok",
                    noline : true
                });

                $("#menu").menu("show",{left:200,top:200});
            });

            function save() {
                alert("saveeeeeeeeeeee");
            }
        </script>
    </body>
</html>
