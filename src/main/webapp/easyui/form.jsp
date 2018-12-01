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

        <form>
            <input type="text" id="vb">
            <hr>

            <input type="text" id="tb">
            <hr>

            <input id="c" value="001">
            <hr>
            <input id="cb" type="text">
            <hr>

            <input id="ct" value="01">
            <hr>

            <input id="cg" type="text">
            <hr>

            <input id="db"/>
            <hr/>

            <div id="ss" style="height:200px"></div>
            <hr>

            <input id="fb" type="text" style="width:300px">
            <hr>


        </form>

        <script>
            $(function () {
                $("#vb").validatebox({
                    required : true
                });
                $("#tb").textbox({
                    required : true,
                    prompt : "Nihao"
                });
                $("#c").combo({
                    required : true,
                    multiple : true
                });
                $("#cb").combobox({
                    valueField : "value",
                    textField : "text",
                    data : [{
                        value : "1",
                        text : "吃饭"
                    },{
                        value : "2",
                        text : "睡觉",
                        selected : true
                    },{
                        value : "3",
                        text : "打豆豆"
                    }]

                });

                $("#ct").combotree({
                    multiple : true,
                    lines : true
                });
                $("#ct").combotree("loadData",[{
                    id: 1,
                    text: 'Languages',
                    iconCls : 'icon-ok',
                    children: [{
                        id: 11,
                        text: 'Java'
                    },{
                        id: 12,
                        text: 'C++'
                    }]
                },{
                    id: 2,
                    text: 'Languages',
                    children: [{
                        id: 21,
                        text: 'Java'
                    },{
                        id: 22,
                        text: 'C++'
                    }]
                }]);

                $('#cg').combogrid({
                    panelWidth:450,
                    value:'006',

                    idField:'code',
                    textField:'name',
                    columns:[[
                        {field:'code',title:'Code',width:60},
                        {field:'name',title:'Name',width:100},
                        {field:'addr',title:'Address',width:120},
                        {field:'col4',title:'Col41',width:100}
                    ]]
                });

                $.fn.datebox.defaults.formatter = function(date){
                    var y = date.getFullYear();
                    var m = date.getMonth()+1;
                    var d = date.getDate();
                    return y + "-" + m + "-" + d;
                };
                $("#db").datebox({
                    width : 500,
                    height : 100
                });

                $('#ss').slider({
                    mode: 'h',
                    range : false,
                    rule : [0,'|',25,'|',50,'|',75,'|',100],
                    tipFormatter: function(value){
                        return value + '%';
                    }
                });

                $('#fb').filebox({
                    buttonText: '选择文件',
                    buttonAlign: 'right'
                });

            });
        </script>
    </body>
</html>
