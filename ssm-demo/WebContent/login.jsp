<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ssm登录</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
</head>
<body>
<form id="adminlogin" name="adminlogin" method="post" 
	action="${pageContext.request.contextPath }/user/login.do">
	<table style="margin:auto;width:100%;height:100%" border=0 cellSpacing=0 cellPadding=0>
		<tbody>
			<tr>
				<td height=150>&nbsp;</td>
			</tr>
			<tr style="height:254px">
				<td>
					<div style="background-color:#278296">
						<div style="BACKGROUND:url(${pageContext.request.contextPath}/images/body_05.jpg) no-repeat;height:155px;">
							<div style="text-align:left;width:265px;float:right;height:125px;_height:95px">
								<table border=0 cellSpacing=0 cellPadding=0 width="100%">
									<tbody>
										<tr>
											<td style="height:45px">
											<input type="text" class="input" value="${user.userName }" name="userName" id="userName"/>
											</td>
											
										</tr>
										<tr>
											<td><input type="password" class="input" value="${user.password }" name="password" id="password"/></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div style="height:1px;clear:both"></div>
							<div style="width:380px;float:right:clear:both">
								<table border=0 cellSpacing=0 cellPadding=0 width=300>
									<tbody>
										<tr>
											<td width=100 align="right">
												<input style="border-width:0px" id="btnLogin"
												src="${pageContext.request.contextPath }/images/btn1.jpg"
												type="image" name="btnLogin" onclick="javascript:login();return false;">
												
												
											</td>
											<td width=100 align="center">
												<input style="border-right-width:0px;border-top-width:0px;border-bottom-width:0px;border-left-width:0px"
												id="btnReset" src="${pageContext.request.contextPath }/images/btn2.jpg"
												type="image" name="btnReset"
												onclick="javascript:adminlogin.reset();return false;"
												>
												
											</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</td>
			</tr>
			
			<tr style="height:30%">
				<td>&nbsp</td>
			</tr>
		</tbody>	
	</table>

</form>
</body>
</html>

<script type="text/javascript">
	if ("${errorMsg}"!='') {
		alert("${errorMsg}");
	}
</script>