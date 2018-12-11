<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<security:authorize access="hasRole=('ROLE_USER')">
<div id="content">
    <form method="POST" enctype="multipart/form-data">
        <input type="file" name="file"></input><br/>
        <input type="submit"></input>
    </form>
</div>
</body>
</security:authorize>
<security:authorize access="hasRole=('permitAll')">
</security:authorize>
</html>