<%@page import="javax.el.ListELResolver"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Excluir Pessoa</title>
	</head>
	<body>
	
		<jsp:useBean id="emailBean" class="br.upis.programacaoweb.Email" scope="request">
			<jsp:setProperty name="emailBean" property="endereco" value="${param.e_mail}" /> 
		</jsp:useBean>
		
		<fmt:formatDate value="${pessoas[emailBean].nascimento}" var="niver" pattern="yyyy-MM-dd" /> 
		
		<form action="Person.jsp" method="post">
			<label>e-mail</label>
			<input type="text" name="e_mail" value="${pessoas[emailBean].email}" disabled="true"><br/>
			<label>First Name</label>
			<input type="text" name="firstName" value="${pessoas[emailBean].nome}" disabled="true"><br/>
			<label>Birthday</label>
			<input type="date" name="birthday" value="${niver}" disabled="true"><br/>
			<input type="hidden" name="e_mail" value="${pessoas[emailBean].email}"> 
			<input type="hidden" name="acao" value="excluir">
			<input type="submit" value="Excluir">			
		</form>	
	</body>
</html>