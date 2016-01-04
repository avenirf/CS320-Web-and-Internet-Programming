<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>EditCourse</title>
<style type='text/css'>
.topcorner{
    position:absolute;
    top:0;
    right:0;}
</style>
</head>
<body>

<c:if test="${empty user}">
<div class='topcorner'> <a href='Login'>Login</a> / <a href='Registration'>Registration</a></div>    
</c:if>

<c:if test="${not empty user}">
<form action='EditCourse' method='post'>
<table border='1'>
    <tr><th>Code:</th> <td><input type='text' name='code2' value="${entry.code}" /></td></tr>
    <tr><th>Title:</th> <td><input type='text' name='title' value="${entry.title}" /></td></tr>
    <tr><th>Prerequisite(s):</th> 
        <td>
        <c:forEach items="${enter}" var="enter">
            <c:choose>
            <c:when test="${ enter.code ne entry.code }">
                <c:choose>
                    <c:when test="${ entry.pre.contains(enter.code) }">
                        <input type='checkbox' checked='checked' name='checkbox' value="${enter.code}" />${enter.code}<br />  
                    </c:when>
                    <c:otherwise>
                        <input type='checkbox' name='checkbox' value="${enter.code}" />${enter.code}<br />  
                    </c:otherwise>
                </c:choose>
            </c:when>
            <c:otherwise> 
            </c:otherwise>
            </c:choose>
        </c:forEach>
        </td>
    </tr>
</table>    
<input type='hidden' name='code' value="${entry.code}" /> <br />
<input type='submit' name='save' value='Save' />
</form>
</c:if>

<div class='topcorner'> Hello <c:out value="${user}"/> <a href='Logout'>Logout</a></div>

</body>
</html>