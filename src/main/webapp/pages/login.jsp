<%--
  Created by IntelliJ IDEA.
  User: Adam
  Date: 2018/11/7
  Time: 9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Login</title>
        <style>
            table {
                width: 380px;
                text-align: center;
            }
            tr {
                height: 50px;
                line-height: 50px;
            }
        </style>
    </head>
    <body>

        <div id="login-dialog">
            <form id="login-form" method="post">
                <table>
                    <tr>
                        <td>编 号</td>
                        <td><input id="username" name="username"></td>
                    </tr>
                    <tr>
                        <td>密 码</td>
                        <td><input id="password" name="password"></td>
                    </tr>
                </table>
            </form>
        </div>

        <!-- 注册 -->
        <div id="register-dialog">
            <form id="register-form">

            </form>
        </div>


        <%@include file="/easyui/include.jsp"%>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/login.js"></script>
    </body>
</html>
