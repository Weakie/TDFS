<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
	File[] files = (File[])request.getAttribute("files");
	File parent = (File)request.getAttribute("file");
%>
	<%=parent.getAbsolutePath() %><br>
<%
	for(File file : files){
%>
		<%=file.getName()%><%=(file.isDirectory()?File.separator:"")%><br>
<%
	}
%>
</body>
</html>
