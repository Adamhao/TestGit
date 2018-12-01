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

        <div id="cc" class="easyui-layout" style="width:600px;height:400px;">
            <div data-options="region:'north',title:'North Title',split:true" style="height:100px;"></div>
            <div data-options="region:'south',title:'South Title',split:true" style="height:100px;"></div>
            <div data-options="region:'east',iconCls:'icon-reload',title:'East',split:true" style="width:100px;"></div>
            <div data-options="region:'west',title:'West',split:true" style="width:100px;"></div>
            <div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;">
                <div class="easyui-layout" data-options="fit:true">
                    <div data-options="region:'west',collapsed:true,title:'west a'" style="width:180px"></div>
                    <div data-options="region:'center',title:'center a',tools:[{iconCls:'icon-man',handler:function(){alert('man----')}}]"></div>
                </div>
            </div>
        </div>


        <script>
            $(function () {

            });
        </script>
    </body>
</html>
