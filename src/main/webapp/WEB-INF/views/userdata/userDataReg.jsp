<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="userdata" class="com.springblgy.dto.UserDataDto" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register USERDATA 2 Session</title>
<jsp:setProperty property="userseq" name="userdata" value="${userData.userseq}"/>
<jsp:setProperty property="nickname" name="userdata" value="${userData.nickname}"/>
<jsp:setProperty property="email" name="userdata" value="${userData.email}"/>
<jsp:setProperty property="telno" name="userdata" value="${userData.telno}"/>
<jsp:setProperty property="xaxis" name="userdata" value="${userData.xaxis}"/>
<jsp:setProperty property="yaxis" name="userdata" value="${userData.yaxis}"/>
<script>
window.location.href = 'mainForm.bill?userseq='+${userData.userseq};
</script>
</head>
<body>
</body>
</html>