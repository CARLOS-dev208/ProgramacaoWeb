
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Editar Pessoa</title>
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
    <input type="text" name="firstName" value="${pessoas[emailBean].nome}"><br/>
    <label>Birthday</label>
    <input type="date" name="birthday" value="${niver}"><br/>
    <input type="hidden" name="e_mail" value="${pessoas[emailBean].email}">
    <input type="hidden" name="acao" value="editar">
    <input type="submit" value="Alterar">
</form>
</body>

</html>
