<%--
  Created by IntelliJ IDEA.
  User: Adam
  Date: 2018/11/6
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Test Textbox</title>
        <%@include file="/easyui/include.jsp" %>
    </head>
    <body>

        <form method="post">
            <input class="easyui-textbox" data-options="iconCls:'icon-man',
                width:300,prompt:'请输入电话号码',type:'text',iconAlign:'left',
                buttonText:'My Button',buttonIcon:'icon-add',buttonAlign:'right',
                onChange:function(newValue,oldValue) {alert(oldValue)},
                onClickButton:function() {alert('吖,我被...了' + $(this).textbox('getValue'))}" />

            <input id="et" width="300px"/>
        </form>

    </body>

    <script>
        $(function () {
            //自定义验证
            $.extend($.fn.validatebox.defaults.rules, {
                etoak : {
//                    value 输入值, param 方法的参数
                    validator: function(value,param){
                        var reg = /^1(3|4|5|6|7|8|9)\d{9}$/;
//                        return value == param[0];
                        return reg.test(value);
                    },
                    //返回false时触发
                    message: 'Field do not match.'
                }
            });

            $("#et").textbox({
                required : true,
                missingMessage : '不能为空...',
                validType : "etoak['123']",
                buttonIcon : 'icon-search',
                onClickButton : function() {
                    alert("kskljhdfk");
                }
            });

            let options = $("#et").textbox("options");
            console.log(options);
        });
    </script>
</html>
