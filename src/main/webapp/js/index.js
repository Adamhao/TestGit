
function logout() {
    window.location.replace(contextPath + "/login/logout");
}

function changePwd() {
    $("#pwd-dialog").dialog({
        title: '修改用户密码',
        width: 400,
        height: 200,
        closed: false,
        cache: false,
        href: contextPath + '/emp/getChangePwdPage',
        modal: true,
        buttons : [{
            text : '保存修改',
            iconCls : 'icon-save',
            handler : function () {

                $("#changePwd-form").form('submit',{
                    url : contextPath + '/emp/changePwd',
                    onSubmit : function () {
                        return $(this).form("validate");
                    },
                    success : function (result) {
                        let data = $.parseJSON(result);
                        if(data.code == 200) {
                            $("#pwd-dialog").dialog("close");
                            $("#pwd-dialog").dialog("clear");
                            window.location.replace(contextPath + "/");
                        }else {
                            $.messager.show({
                                title: "修改结果",
                                msg: data.msg,
                                timeout: 5000,
                                showType: 'slide'
                            });
                        }
                    }
                });
            }
        }]

    });
}

function tabs(option) {
    //获取选项卡对象
    let tabs = $("#content");
    let exists = tabs.tabs("exists",option.title);
    if(exists) {
        tabs.tabs("select",option.title);
        let tab = tabs.tabs("getTab",option.title);
        tabs.tabs("update",{
            tab : tab,
            options : {
                title : option.title,
                href : option.content,
                closable : true
            }
        });

    }else {
        tabs.tabs("add",{
            title : option.title,
            content : option.content,
            selected : true,
            closable : true
        });
    }
}


$(function () {
    $.extend($.fn.validatebox.defaults.rules, {
        check: {
            validator: function(value,param){
                return value == $(param[0]).val();
            },
            message: '密码不一致.'
        }
    });

    $("a.opts").click(function () {
        let url = $(this).attr("url");
        if(url != undefined && url != null && url != '') {
            let option = {
                "title" : $(this).text(),
                "content" : '<iframe src="' + contextPath + url +'" frameborder="0" width="100%" height="100%" scrolling="auto"></iframe>'
            };

            tabs(option);
        }
    });


});