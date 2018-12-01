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
        <title>Panel</title>
        <%@include file="/easyui/include.jsp" %>
    </head>
    <body>
        <div id="panel">
            <h1>哈哈哈哈哈</h1>
            <p>这是什么....</p>
            <footer>这是页脚</footer>
        </div>

        <script>
            $(function () {
                $("#panel").panel({
                    width : 500,
                    height : 150,
                    title : "Adam's Panel",
                    iconCls : "icon-man",
                    tools : [{
                        iconCls : "icon-add",
                        handler : function() {
                            alert("添加成功");
                        }
                    },{
                        iconCls : "icon-save",
                        handler : function() {
                            alert("保存成功");
                        }
                    }],
                    style : {borderWidth : 5},
                    collapsible : true,
                    closable : true
                });

                $("#panel").panel('move',{left : 100,top : 200});
            });
        </script>
    </body>
</html>
