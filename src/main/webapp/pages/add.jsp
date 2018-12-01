<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>新增用户</title>
	</head>
	<body>
		
		<form id="user-form">
			姓名:<input type="text" name="username"/> <br/>
			密码:<input type="password" name="password"/> <br/>
			<input type="button" value="新增" onclick="add()"/>
		</form>
		
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
		<script>
			function add() {
				$.ajax({
					url : "${pageContext.request.contextPath}/user/add",
					type : "post",
					data : $("#user-form").serialize(),
					dataType : "json",
					success : function(data) {
						alert(data.msg);
						if(data.flag == "success") {
							//window.location.href="";
						}
					},
					error : function() {
						alert("系统出错,稍后重试...");
					}
				});
			}
		</script>
	</body>
</html>