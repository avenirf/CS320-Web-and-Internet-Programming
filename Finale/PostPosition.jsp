<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Post a position</title>
</head>
<body>

<p style="margin-left: 40px;"><strong><a href="CSJobs">CS Jobs</a> - Job Positions</strong></p>

<form action='PostPosition' method='post'>
<ul>
<c:forEach items="${entries}" var="entry">
    <li style="margin-left: 40px;">${ entry }</li>
</c:forEach>
</ul>

<p style="margin-left: 40px;">New Position: <input name="position" type="text" /> <input name="add" type="submit" value="Add" /></p>
</form>

</body>
</html>