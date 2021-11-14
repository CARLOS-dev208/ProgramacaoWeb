<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Pessoas</title>
</head>
<body>
<table border="1">
        <thead>
                <th>Nome</th>
                <th>Data de nascimento</th>
                <th>Idade</th>
        </thead>
    <tbody>
            <jsp:useBean id="listPessoas" scope="request" type="java.util.List"/>
            <c:forEach items="${listPessoas}" var="p">
                <tr>
                    <td>${p.nome}</td>
                    <td><fmt:formatDate value="${p.nascimento}"  pattern="dd/MM/yyyy" /></td>
                    <td>${p.idade}</td>
                </tr>
            </c:forEach>
    </tbody>
</table>

</body>
</html>
