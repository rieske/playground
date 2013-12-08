<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="jsp.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<%
		out.print("throwException.jsp");
		if (true) {
			throw new Exception("exception from throwException.jsp");
		}
	%>
</body>