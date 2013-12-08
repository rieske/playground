<%@ page import="java.io.IOException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP examples</title>
<%!private void describeVariable(String varName, Class<?> varClass, Object var, JspWriter out) throws IOException {
		out.print("<p>");
		out.print(varName + " (" + varClass.getName() + "): " + var);
		out.print("<br />");
		out.print(varName + " instanceof " + varClass.getName() + ": " + varClass.isInstance(var));
		out.print("</p>");
	}%>
</head>
<body>
	<article>
		<section>
			<header>
				<h3>Implicit variables</h3>
			</header>
			<%
				describeVariable("application", ServletContext.class, application, out);
				describeVariable("config", ServletConfig.class, config, out);
				describeVariable("out", JspWriter.class, out, out);
				describeVariable("page", Object.class, page, out);
				describeVariable("this", Object.class, this, out);
				describeVariable("pageContext", PageContext.class, pageContext, out);
				describeVariable("request", ServletRequest.class, request, out);
				describeVariable("response", ServletResponse.class, response, out);
				describeVariable("session", HttpSession.class, session, out);
				describeVariable("exception", Throwable.class, exception, out);
			%>
		</section>
		<section>
			<header>
				<h3>Exception example</h3>
			</header>
			<a href="throwException.jsp">Exception throwing jsp</a>
		</section>
		<section>
			<header>
				<h3>Standard actions</h3>
			</header>
			<p></p>
		</section>
	</article>
</body>