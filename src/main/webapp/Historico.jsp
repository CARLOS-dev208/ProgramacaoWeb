<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<table border="1">
		  <tr>
		  	<th>Identicador</th>
		  	<th>E-mail</th>
		    <th>Nome</th>
		    <th>Nascimento</th>
		    <th>Idade</th>
		    <th>Editar</th>
		    <th>Excluir</th>
		  </tr>
		  <c:forEach items="${pessoas.values()}" var="p" varStatus="i">
				<tr>
					<td>${i.count}</td>
					<td>${p.email}</td>
			    	<td>${p.nome}</td>
			    	<td><fmt:formatDate value="${p.nascimento}" pattern="dd-MM-yyyy"/></td>
			    	<td>${p.idade}</td>
			    	<td><a href="Editar.jsp?e_mail=${p.email.endereco}"><img src="icon/edit.png"/></a></td>
			    	<td><a href="Excluir.jsp?e_mail=${p.email.endereco}">excluir</a></td>
			  	</tr>
		  </c:forEach>			
		</table>
	</body>
</html>