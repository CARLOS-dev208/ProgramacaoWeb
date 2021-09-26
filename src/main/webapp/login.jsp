<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="css/global.css">
</head>
<body>
<%--<header class="header"></header>--%>
    <div class="lista">
        <%for (String l : (List<String>) request.getAttribute("logins")) {%>
            <%= l %>
        <br/>
        <%}%>
    </div>
</body>
</html>
