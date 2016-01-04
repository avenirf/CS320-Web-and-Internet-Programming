<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Course Planner 2</title>
</head>
<body>


<c:if test="${empty param.next and empty param.finish}">
<p><a href="Done">Main Page</a></p>
<p>Please select the courses you have already taken:</p>
<form action='CoursePlanner2' method='post'>
<table border="1">
<tr><th></th><th>Code</th><th>Title</th><th>Prerequisites</th></tr>
<c:forEach items="${quarter}" var="quarter">
    <tr>
        <td><input type='checkbox' name='checkbox' value="${quarter.code}" /></td>
        <td>${quarter.code}</td>
        <td>${quarter.title}</td>
        <td><c:out value="${quarter.pre}" escapeXml="true" /></td>
    </tr>
</c:forEach>
</table>
<input type='hidden' name='bool' value="true" /> <br />
<p><input type='submit' name='next' value='Next' /></p>
</form>
</c:if>


<c:if test="${not empty param.next and not empty quarter}">
<form action='CoursePlanner2' method ='post'>
<p><a href="Done">Main Page</a></p>
<p>You may take the following courses in <c:out value="${quart}"/> </p>
<table border="1">
<tr><th></th><th>Code</th><th>Title</th><th>Prerequisites</th></tr>
<c:forEach items="${quarter}" var="quarter">    
    <c:choose>
        <c:when test="${ empty quarter.pre }">
        <tr>
            <td><input type='checkbox' name='checkbox' value="${quarter.code}" /></td>
            <td>${quarter.code}</td>
            <td>${quarter.title}</td>
            <td><c:out value="${quarter.pre}" escapeXml="true" /></td>
        </tr>
        </c:when>    
        <c:otherwise>
            <c:if test="${ codeList.contains ( quarter.pre ) or quarter.check }">
            <tr>
                <td><input type='checkbox' name='checkbox' value="${quarter.code}" /></td>
                <td>${quarter.code}</td>
                <td>${quarter.title}</td>
                <td>${quarter.pre}</td>
            </tr>
            </c:if>    
        </c:otherwise>
    </c:choose>
</c:forEach>
</table>
<input type='hidden' name='idd' value='-2' /> <br />
<p><input type='submit' name='next' value='Next'/>  <input type="submit" name='finish' value='Finish'/></p>
</form>
</c:if>


<c:if test='${ empty quarter or not empty param.finish }'>
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
    
    <p><a href="Done">Done</a> 
    <c:if test='${ not empty user }'> 
        | <a href="Save">Save This Course Plan</a></p>    
    </c:if>
</c:if>

</body>
</html>