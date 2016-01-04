<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Login</title>
<style type='text/css'>
.topcorner{
    position:absolute;
    top:0;
    right:30;}
#red {color: red;}
</style>
</head>
<body>

<form action='Login' method='post'>
    <table id='tb1' border='1'>
        <tr><td>Username:</td> <td><input type='text' name='username' /></td></tr>
        <tr><td>Password:</td> <td> <input type='password' name='password' /></td></tr>
    </table> <br />
    <input type='submit' name='login' value='Login' /> <br />
</form>

</body>
</html>