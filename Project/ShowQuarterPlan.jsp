<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Show Quarter Plan</title>
</head>
<body>

<c:if test='${ empty date }'>
    Your Course Plans:
    <ul>
    <c:forEach items="${ savedPlans }" var="plans">
        <li style="margin-left: 40px;"><a href="ShowQuarterPlan?date=${ plans }">Saved ${ plans }</a></li>
    </c:forEach>
    </ul>   
    <p><a href='CoursePlanner'>Main Page</a></p>
</c:if>

<c:if test='${ not empty date }'>
    <p>Here is your course plan:</p>
    <c:forEach items="${quarterPlan}" var="quarterPlan">
        <p>${quarterPlan.quarter}</p>
        <table border="1">
        <tr><th>Code</th><th>Title</th><th>Prerequisites</th></tr>
        <c:forEach items="${ quarterPlan.list }" var="list">
        <tr>
            <td>${list.code}</td>
            <td>${list.title}</td>
            <td><c:out value="${list.pre}" escapeXml="true" /></td>
        </tr>
        </c:forEach>
        </table>
    </c:forEach> 
    
    <input type="hidden" name="????" ><c:set var="show" value="false" /></input>
    <p><a href="ShowQuarterPlan">Back</a></p>
</c:if>

</body>
</html>