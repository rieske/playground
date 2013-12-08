<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Playground index</title>
</head>
<body>
	<ul>
		<li><a href="${pageContext.request.contextPath}/annotatedServlet">annotatedServlet</a></li>
		<li><a href="${pageContext.request.contextPath}/asyncServlet">asyncServlet</a></li>
		<li><a href="${pageContext.request.contextPath}/content/jsp.jsp">JSP
				examples</a></li>
		<li><a href="${pageContext.request.contextPath}/content/el.jsp">EL
				expressions</a></li>
		<li><a href="${pageContext.request.contextPath}/content/jstl.jsp">JSTL
				examples</a></li>
		<li><a
			href="${pageContext.request.contextPath}/content/customTags.jsp?userName=testUser">Custom
				tags</a></li>
	</ul>
</body>