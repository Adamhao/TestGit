
$(function () {

    $("#emp-list").datagrid({
        url : contextPath + '/emp/queryEmpList',
        method : 'post',
        striped : true,
        loadMsg : '努力加载数据中...',
        pagination : true,
        rownumbers : true,
        pageNumber : 1,
        pageSize : 10,
        pageList : [10,20,50],
        fit : true,
        fitColumns : true,
        toolbar : '#emp-list-toolbar',
        columns : [[
            {title : "主键ID",field : "id",checkbox : true},
            {title : "员工姓名",field : "ename",align : 'center'},
            {title : "员工编号",field : "eno",align : 'center'},
            {title : "员工职位",field : "job",align : 'center',
                formatter : function (value,row,index) {
                    if(value == 'gcs') {
                        return '工程师';
                    }else if (value == 'president') {
                        return '教学总监';
                    }else if(value == 'xzzl') {
                        return '行政助理';
                    }else {
                        return '';
                    }
                }},
            {title : "员工薪资",field : "salary",align : 'center'},
            {title : "员工部门",field : "dname",align : 'center'},
            {title : "入职时间",field : "hiredate",align : 'center'}
        ]],

    });


});

let eventObj = {
    query : function () {
        $("#emp-dialog").dialog({
            title: '员工查询',
            width: 400,
            height: 280,
            closed: false,
            cache: false,
            href: contextPath + "/pages/emp/query.jsp",
            modal: true,
            buttons : [{
                text : '查询',
                iconCls : 'icon-search',
                disabled : true,
                handler : function () {
                    $('#emp-list').datagrid('load',{
                        ename : $("#ename").textbox('getValue'),
                        did : $("#did").combobox('getValue'),
                        startTime : $("#startTime").datebox('getValue'),
                        endTime : $("#endTime").datebox('getValue')
                    });

                    $('#emp-dialog').dialog('close');

                    $('#emp-dialog').dialog('clear');
                }
            }]
        });
    },
    add : function () {
        $("#emp-dialog").dialog({
            title : '用户注册',
            width: 450,
            height: 350,
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
                                $("#emp-dialog").dialog("close",{forceClose : true});
                                $("#emp-dialog").dialog("clear");
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
    },
    update : function () {

        let emp_selected = $("#emp-list").datagrid("getSelections");

        if(emp_selected == null || emp_selected.length != 1) {
            $.messager.show({
                title : '提示',
                msg : '请选择一条数据',
                timeout : 5000,
                showType : 'slide'
            });
            return ;
        }

        let row = emp_selected[0];
        $("#emp-dialog").dialog({
            title: '员工修改',
            width: 400,
            height: 280,
            closed: false,
            cache: false,
            href: contextPath + "/emp/empAddAndUpdate?id=" + row.id,
            modal: true,
            buttons : [{
                text : '修改',
                iconCls : 'icon-save',
                handler : function () {
                    $("#emp-form").form('submit',{
                        url : contextPath + "/emp/updateEmp",
                        onSubmit : function (p) {
                            p.id = row.id;
                            let reg_did = /^\d+$/
                            if(!reg_did.test($("#did").combotree("getValue"))) {
                                $("input[name='did']").val('');
                            }
                            return $(this).form("validate");
                        },
                        success : function (result) {
                            let data = $.parseJSON(result);
                            if(data.code == 200) {
                                $("#emp-dialog").dialog('close');
                                $("#emp-dialog").dialog('clear');
                                $("#emp-list").datagrid('reload');
                            }

                            $.messager.show({
                                title : '提示',
                                msg : data.msg,
                                timeout : 5000,
                                showType : 'slide'
                            });
                        }
                    });
                }
            }]
        });
    },
    remove : function () {
        let emp_selected = $("#emp-list").datagrid("getSelections");

        if(emp_selected == 0) {
            $.messager.show({
                title : '提示',
                msg : '请至少选择一条数据',
                timeout : 5000,
                showType : 'slide'
            });
            return ;
        }

        $.messager.confirm('确认','您确认想要删除记录吗?',function (r) {
            if(r) {
                let ids = $.map(emp_selected,function (row) {
                    return row.id;
                });
                $.ajax({
                    url : contextPath + "/emp/remove",
                    type : 'post',
                    contentType : 'application/json',
                    data : JSON.stringify(ids),
                    dataType : 'json',
                    success : function (result) {
                        if(result.code == 200) {
                            $("#emp-list").datagrid("load");
                        }

                        $.messager.show({
                            title : '提示',
                            msg : result.msg,
                            timeout : 5000,
                            showType : 'slide'
                        });
                    }
                });
            }
        });
    }
};



