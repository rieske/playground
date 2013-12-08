<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Custom tags</title>
</head>
<body>
	<article>
		<section>
			<header>
				<h3>Custom EL functions</h3>
			</header>
			&lt;%@taglib uri="http://lt.rieske.showcase/functions"
			prefix="f"%&gt;
			<%@taglib uri="http://lt.rieske.showcase/functions" prefix="f"%>
			<p>\${f:greet(param.userName) }: ${f:greet(param.userName) }</p>
			<p>\${f:greet(null) }: ${f:greet(null) }</p>
		</section>
	</article>

</body>