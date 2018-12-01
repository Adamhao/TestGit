<%--
  Created by IntelliJ IDEA.
  User: Adam
  Date: 2018/11/7
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>addAndUpdate</title>
    </head>
    <body>
        <form id="emp-form" method="post">
            <%--<input type="hidden" name="id" value="${e.id}">--%>
            <table style="margin: 20px auto;" cellspacing="2px" cellpadding="2px">
                <tr>
                    <td>员工姓名</td>
                    <td><input class="easyui-textbox" data-options="
                        required:true,width:180" name="ename" value="${e.ename}"/></td>
                </tr>
                <tr>
                    <td>员工编号</td>
                    <td>
                        <c:choose>
                            <c:when test="${empty e}">
                                <input class="easyui-textbox" data-options="
                        required:true,width:180" name="eno"  value="${e.eno}"/>
                            </c:when>
                            <c:otherwise>
                                <span style="font-weight: bolder;color: skyblue;">${e.eno}</span>
                            </c:otherwise>
                        </c:choose>

                    </td>
                </tr>
                <c:if test="${empty e}">
                    <tr>
                        <td>登录密码</td>
                        <td><input id="pwd" class="easyui-textbox" data-options="
                            required:true,width:180,type:'password'" name="password"  value="${e.password}"/></td>
                    </tr>
                    <tr>
                        <td>确认密码</td>
                        <td><input id="rpwd" class="easyui-textbox" data-options="
                            required:true,width:180,type:'password'"
                                validType="check['#pwd']"/></td>
                    </tr>
                </c:if>
                <tr>
                    <td>员工职位</td>
                    <td><input class="easyui-combobox" data-options="
                        required:true,width:180,valueField: 'label',
                        textField: 'value',
                        data: [{
                            label: 'gcs',
                            value: '工程师'
                        },{
                            label: 'xzzl',
                            value: '行政助理'
                        },{
                            label: 'president',
                            value: '教学总监'
                        }]" name="job"  value="${e.job}"/></td>
                </tr>

                <tr>
                    <td>员工工资</td>
                    <td>
                        <a class="easyui-linkbutton" data-options="iconCls:'icon-add',onClick:function(){$('#salary').numberbox('setValue',parseInt($('#salary').numberbox('getValue')) + 100);}"></a>
                        <input id="salary" class="easyui-numberbox" data-options="
                        required:true,width:118" name="salary"  value="${e.salary}"/>
                        <a class="easyui-linkbutton" data-options="iconCls:'icon-remove',
                        onClick : function(){
                            $('#salary').numberbox('setValue',$('#salary').numberbox('getValue') - 100);
                      }"></a>
                    </td>
                </tr>

                <tr>
                    <td>所在部门</td>
                    <td>
                        <input id="did" name="did" class="easyui-combotree" data-options="
                        required:true,width:180,
                        url:'${pageContext.request.contextPath}/dept/getDept',
                        animate:true,lines:true"  value="${e.dname}"/>
                    </td>
                </tr>

            </table>
        </form>
    </body>
</html>
