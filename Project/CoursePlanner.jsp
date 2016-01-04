<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>CoursePlanner</title>
<style type='text/css'>
.topcorner{
    position:absolute;
    top:0;
    right:0;}
</style>
</head>
<body>

<c:if test="${empty user}">
<table border="1">
<tr><th>Code</th><th>Title</th><th>Prerequisites</th></tr>
<c:forEach items="${entries}" var="entry">
    <tr>
        <td>${entry.code}</td>
        <td>${entry.title}</td>
        <td><c:out value="${entry.pre}" escapeXml="true" /></td>
    </tr>
</c:forEach>
</table>
<div class='topcorner'> <a href='Login'>Login</a> / <a href='Registration'>Registration</a></div>
</c:if>

<c:if test="${not empty user}">
<table border="1">
<tr><th>Code</th><th>Title</th><th>Prerequisites</th></tr>
<c:forEach items="${entries}" var="entry">
    <tr>
        <td>${entry.code}</td>
        <td>${entry.title}</td>
        <td><c:out value="${entry.pre}" escapeXml="true" /></td>
        <td><a href="EditCourse?code=${entry.code}">Edit</a></td>
        <td><a href="DeleteCourse?code=${entry.code}">Delete</a></td>
    </tr>
</c:forEach>
</table>
<div class='topcorner'> Hello <c:out value="${user}"/> <a href='Logout'>Logout</a></div>
<p><a href='AddCourse'>Add Course</a></p>
<br />
<p><a href='ShowQuarterPlan'>Saved Course Plans</a></p>
</c:if>

<br />
<p><a href='CoursePlanner2'>Course Planner</a></p>

</body>
</html>