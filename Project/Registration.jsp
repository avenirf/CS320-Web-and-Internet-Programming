<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Registration</title>

<style type='text/css'>
#red{color: red;}
</style>

</head>
<body>

<form id='myForm' action='Registration' method='post'>
<table id='tb1' border='1'>
<tr><td>Username: *</td> <td><input type='text' name='username' /></td></tr>
<tr><td>Password: *</td> <td><input type='password' name='pass' /></td></tr>
<tr><td>Re-type password: *</td> <td><input type='password' name='rePass' /></td></tr>
<tr><td>First Name (optional): </td> <td><input type='text' name='fName' /></td></tr>
<tr><td>Last Name (optional): </td> <td><input type='text' name='lName' /></td></tr></table> <br />
<input type='submit' name='register' value='Register' /> <br />
</form>




</body>
</html>