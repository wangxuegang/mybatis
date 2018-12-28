<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath(); 
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>测试</title>
<script type="text/javascript" src="resources/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		
		//加载用户列表
		$.ajax({
		   type: "get",
		   url: "user/userList",
		   success: function(msg){
		     if(msg.code != 0){
		    	 var tab = document.getElementById("tableDemo");
		    	 for (var i = 0; i < msg.success.length; i++) {
		    		 $("#tableDemo").append(
		    				    "<tr>"+
		    				     "<td><input class='userId' type='text' value='"+msg.success[i].userId+"'/></td>"+ 
		    				     "<td><input class='loginName' type='text' value='"+msg.success[i].loginName+"'/></td>"+
		    				     "<td><input class='userName' type='text' value='"+msg.success[i].userName+"'/></td>"+
		    				     "<td><input class='password' type='text' value='"+msg.success[i].password+"'/></td>"+ 
		    				     "<td><input class='phone' type='text' value='"+msg.success[i].phone+"'/></td>"+
		    				     "<td><input class='email' type='text' value='"+msg.success[i].email+"'/></td>"+
		    				     "<td><input class='createDate' type='text' value='"+msg.success[i].createDate+"'/></td>"+
		    				     "<td>"+
		    				     	"<input type='button' value='编辑' onclick='edit("+tab.rows.length+")'/>"+
		    				     	"<input type='button' value='删除' onclick='del("+tab.rows.length+")'/>"+
		    				     "</td>"+
		    				    "</tr>"
		    				   );
				}
		     }
		   }
		});
		
	});
	
	//删除
	function del(e){
		var userId = $("table tr:eq("+e+")").children("td:eq(0)").find("input").val();
		$.ajax({
			   type: "post",
			   url: "user/delUser",
			   contentType: "application/json;charset=utf-8",
			   data: JSON.stringify({userId:userId}),
			   success: function(msg){
				   alert(msg.code != 0 ? msg.success:msg.error);
				   window.location.reload();
			   }
		});
	}
	
	//添加
	function add(){
		var tab = document.getElementById("tableDemo");
		$("#tableDemo").append(
				"<tr>"+
			     "<td></td>"+ 
			     "<td><input class='loginName' type='text' value=''/></td>"+
			     "<td><input class='userName' type='text' value=''/></td>"+
			     "<td><input class='password' type='text' value=''/></td>"+ 
			     "<td><input class='phone' type='text' value=''/></td>"+
			     "<td><input class='email' type='text' value=''/></td>"+
			     "<td></td>"+
			     "<td>"+
			     	"<input type='button' value='提交' onclick='sub("+tab.rows.length+")'/>"+
			     "</td>"+
			    "</tr>"
			   );
	}
	
	//提交
	function sub(e){
		var loginName = $("table tr:eq("+e+")").children("td:eq(1)").find("input").val();
		var userName = $("table tr:eq("+e+")").children("td:eq(2)").find("input").val();
		var password = $("table tr:eq("+e+")").children("td:eq(3)").find("input").val();
		var phone = $("table tr:eq("+e+")").children("td:eq(4)").find("input").val();
		var email = $("table tr:eq("+e+")").children("td:eq(5)").find("input").val();
		
		$.ajax({
			   type: "post",
			   url: "user/addUser",
			   contentType: "application/json;charset=utf-8",
			   data: JSON.stringify({loginName:loginName,userName:userName,password:password,phone:phone,email:email}),
			   success: function(msg){
				   alert(msg.code != 0 ? msg.success:msg.error);
				   window.location.reload();
			   }
		});
	}
	
</script>
</head>
<body>
	<h1>SSM Demo</h1>
	<input type="button" value="添加" onclick="add()">
	<table id="tableDemo" border="1" cellpadding="10" cellspacing="0">
		<tr>
			<th>序号</th>
			<th>登录名</th>
			<th>姓名</th>
			<th>密码</th>
			<th>手机号</th>
			<th>邮箱</th>
			<th>时间</th>
			<th>操作</th>
		</tr>
	</table>
</body>
</html>