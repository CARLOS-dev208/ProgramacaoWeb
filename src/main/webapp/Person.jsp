<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Pessoa</title>
</head>
<body>

<fmt:parseDate value="${param.birthday}" var="niver" pattern="yyyy-MM-dd" />

<jsp:useBean id="emailBean" class="br.upis.programacaoweb.Email" scope="request">
    <jsp:setProperty name="emailBean" property="endereco" value="${param.e_mail}" />
</jsp:useBean>

<jsp:useBean id="pessoaBean" class="br.upis.programacaoweb.Pessoa" scope="request">
    <jsp:setProperty name="pessoaBean" property="nome" value="${param.firstName}" />
    <jsp:setProperty name="pessoaBean" property="nascimento" value="${niver}" />
    <jsp:setProperty name="pessoaBean" property="email" value="${emailBean}" />
</jsp:useBean>

<jsp:forward page="/cadastroPessoa"/>

</body>

</html>
