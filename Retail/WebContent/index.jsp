<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Retail Lite</title>
</head>
<body>
Welcome to the world of Retail Lite.
<%
		System.out.println ("request  attributes are"+request.getParameter("QueueId"));
		System.out.println ("request stat attributes are"+request.getParameter("stat"));
 %>
</body>
</html>