<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/el.css">
<script
	src="${pageContext.request.contextPath}/js/lib/jquery-1.10.2.min.js"></script>
<script src="${pageContext.request.contextPath}/js/toggleELValue.js"></script>
<title>EL expressions</title>
</head>
<body>
	<nav><%@ include file="/WEB-INF/includes/backToIndex.jsp"%></nav>
	<article>
		<section>
			<header>
				<h3>Implicit variables</h3>
			</header>
			<p class="el-name">
				\${pageContext }<span class="el-value">: ${pageContext }</span>
			</p>
			<p class="el-name">
				\${pageScope }<span class="el-value">: ${pageScope }</span>
			</p>
			<p class="el-name">
				\${requestScope }<span class="el-value">: ${requestScope }</span>
			</p>
			<p class="el-name">
				\${sessionScope }<span class="el-value">: ${sessionScope }</span>
			</p>
			<p class="el-name">
				\${applicationScope }<span class="el-value">:
					${applicationScope }</span>
			</p>
			<p class="el-name">
				\${param }<span class="el-value">: ${param }</span>
			</p>
			<p class="el-name">
				\${paramValues }<span class="el-value">: ${paramValues }</span>
			</p>
			<p class="el-name">
				\${header }<span class="el-value">: ${header }</span>
			</p>
			<p class="el-name">
				\${headerValues }<span class="el-value">: ${headerValues }</span>
			</p>
			<p class="el-name">
				\${cookie }<span class="el-value">: ${cookie }</span>
			</p>
			<p class="el-name">
				\${initParam } (context parameters defined in web.xml)<span
					class="el-value">: ${initParam }</span>
			</p>
		</section>
		<section>
			<header>
				<h3>Variable usage</h3>
			</header>
			<p>\${nonexistentVariable }: ${nonexistentVariable }</p>
			<p>\${nonexistentVariable[0] }: ${nonexistentVariable[0] }</p>
			<p>\#{nonexistentVariable }: translation error - \#\{ } not
				allowed in template text</p>
			<p class="el-name">
				\${applicationScope['org.apache.tomcat.util.scan.MergedWebXml'] }<span
					class="el-value">:
					${applicationScope['org.apache.tomcat.util.scan.MergedWebXml'] }</span>
			</p>
			<div>
				<p>
					&lt;%!int answer = 42;%&gt;
					<%!int answer = 42;%>
					\${answer }: ${answer }
				</p>
				<p>
					&lt;% request.setAttribute("answer", answer);%&gt;
					<%
						request.setAttribute("answer", answer);
					%>
					\${answer }: ${answer }
				</p>
			</div>
		</section>
		<section>
			<header>
				<h3>Expressions</h3>
			</header>
			<p>\${123 }: ${123 }</p>
			<p>\${'abc' }: ${'abc' }</p>
			<p>\${a+b }: ${a+b }</p>
			<p>\${'a'+b }: java.lang.NumberFormatException: For input string:
				"a"</p>
			<p>\${'a'+'b' }: java.lang.NumberFormatException: For input
				string: "a"</p>
			<p>\${a &lt; b }: ${a < b }</p>
			<p>\${'a' &lt; b }: ${'a' < b }</p>
			<p>\${'a' &lt; 'b' }: ${'a' < 'b' }</p>
			<p>\${a == b }: ${a == b }</p>
			<p>\${'a' == b }: ${'a' == b }</p>
			<p>\${'a' == 'b' }: ${'a' == 'b' }</p>
			<p>\${empty '' }: ${empty '' }</p>
			<p>\${empty 'a' }: ${empty 'a' }</p>
			<p>\${empty cookie }: ${empty cookie }</p>
			<p>\${not cookie }: javax.el.ELException: Cannot convert
				{JSESSIONID=javax.servlet.http.Cookie@305f6fc9} of type class
				javax.servlet.jsp.el.ImplicitObjectELResolver$ScopeManager$2 to
				class java.lang.Boolean</p>
			<p>\${not a }: ${not a }</p>
			<p>\${2 / 0}: ${2 / 0}</p>
			<p>\${2 mod 0}: java.lang.ArithmeticException: / by zero</p>
		</section>
	</article>
</body>
