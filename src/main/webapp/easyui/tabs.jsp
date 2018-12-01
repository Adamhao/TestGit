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
        <title>Tabsss</title>
        <%@include file="/easyui/include.jsp" %>
    </head>
    <body>
        <div id="tt">
            <div id="tab1" title="tab1">
                tab111111
            </div>
            <div id="tab2" title="tab2">
                tab22222
            </div>
            <div id="tab3" title="tab3">
                tab3333
            </div>
        </div>

        <script>
            $(function () {
                $("#tt").tabs({
                    justified : true,
                    pill : true,
                    onSelect : function (title) {
                        alert(title + "is onSelected!!");
                    },
                    tools : [{
                        iconCls : "icon-ok",
                        handler : function() {
                            alert("ok");
                        }
                    }]
                });

                $("#tt").tabs("add",{
                    title : "new Title",
                    content : "new Content Body",
                    closable : true,
                    tools : [{
                        iconCls : "icon-mini-refresh",
                        handler : function(){
                            alert("refresh");
                        }
                    }]
                });
            });
        </script>
    </body>
</html>
