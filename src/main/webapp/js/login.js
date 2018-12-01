$(function () {

    //初始化登录窗口
    $("#login-dialog").dialog({
        title : '用户登录',
        width: 400,
        height: 200,
        closed: false,
        closable : false,
        draggable : false,
        resizable : false,
        cache : false,
        modal : true,
        buttons : [{
            text : '登录',
            width : 80,
            iconCls : 'icon-ok',
            handler : function () {
                $("#login-form").form("submit",{
                    url : contextPath + '/login/login',
                    onSubmit : function (p) {
                        return $(this).form('validate');
                    },
                    success : function (result) {
                        var data = $.parseJSON(result);
                        if (data.code == 200){
                            window.location.href = contextPath + "/login/index";
                        }

                        $.messager.show({
                            title:'登录结果',
                            msg : data.msg,
                            timeout:5000,
                            showType:'slide'
                        });

                    }
                });
            }
        },{
            text : '注册',
            width : 80,
            iconCls : 'icon-add',
            handler : function () {
                $("#register-dialog").dialog({
                    title : '用户注册',
                    width: 450,
                    height: 550,
                    closed: false,
                    resizable : false,
                    cache : false,
                    //method : 'post',
                    href : contextPath + '/emp/empAddAndUpdate',
                    //遮罩层
                    modal : true,
                    buttons : [{
                        text : '注册',
                        iconCls : 'icon-ok',
                        handler : function () {
                            $("#emp-form").form('submit',{
                                url : contextPath + '/emp/add',
                                onSubmit : function (p) {
                                    p.etoak = 'et1807';
                                    return $(this).form('validate');
                                },
                                success: function(data){
                                    var data = $.parseJSON(data);  // change the JSON string to javascript object
                                    if (data.code == 200){
                                        $("#register-dialog").dialog("close",{forceClose : true});
                                        $("#register-dialog").dialog("clear");
                                    }

                                    $.messager.show({
                                        title:'注册结果',
                                        msg : data.msg,
                                        timeout:5000,
                                        showType:'slide'
                                    });

                                }
                            });
                        }
                    }]
                });
            }
        }]
    });

    //设置窗口绝对居中
    $("#login-dialog").dialog("center");


    //自定义用户名验证规则
    $.extend($.fn.validatebox.defaults.rules, {
        vname : {
            validator: function(value,param){
                //value = $.trim(value);
                return value.length > 0 && value.length < 10;
            },
            message: '用户名长度应小于10位'
        }
    });

    //判断密码是否一致
    $.extend($.fn.validatebox.defaults.rules, {
        check: {
            validator: function(value,param){
                return value == $(param[0]).val();
            },
            message: '密码不匹配..'
        }
    });

    //初始化用户名
    $("#username").textbox({
        width : 180,
        required : true,
        iconCls : 'icon-man',
        iconAlign : 'left',
        validType : 'vname',
        missingMessage : '请输入用户名'
    });

    //初始化密码框
    $("#password").textbox({
        width : 180,
        required : true,
        type : 'password',
        iconCls : 'icon-lock',
        iconAlign : 'left',
        missingMessage : '请输入密码'
    });


});