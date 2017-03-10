<%--
  Created by IntelliJ IDEA.
  User: chenghuanhuan
  Date: 15/10/22
  Time: 下午2:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/view/common/taglibs.jsp"%>
<html>
<head>
    <title></title>
</head>
<body>
hello!!!!!!!!!!!!

<form action="/rest/user/1" method="post">
  <input type="hidden" name="_method" value="PUT">
  <input type="submit" value="put">
</form>

<form action="/rest/user/1" method="post">
  <input type="submit" value="post">
</form>

<form action="/rest/user/1" method="get">
  <input type="submit" value="get">
</form>

<form action="/rest/user/1" method="post">
  <input type="hidden" name="_method" value="DELETE">
  <input type="submit" value="<spring:message code="submit" /> delete">
</form>

</body>
</html>
