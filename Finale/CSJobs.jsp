<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>CS Jobs</title>
</head>
<body>

<div style="margin-left: 40px;">
<p><strong>CS Jobs</strong></p>

<p><a href="PostPosition">Post A Position</a> | <a href="ApplyForPosition">Apply For Position(s)</a></p>

<table border="1" cellpadding="2" cellspacing="2">
    <thead>
        <tr>
            <th><a href="CSJobs">Position</a></th>
            <th><a href="Applicant">Applicant</a></th>
            <th><a href="Submitted">Submitted On</a></th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${entries}" var="entry">
        <tr>
            <td style="text-align: center;">${entry.position}</td>
            <td style="text-align: center;">${entry.applicant}</td>
            <td style="text-align: center;">${entry.submitted}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>

</body>
</html>