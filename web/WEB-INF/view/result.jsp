<%--
  Created by IntelliJ IDEA.
  User: Joshgun
  Date: 9/13/2018
  Time: 7:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    if (request.getAttribute("message") != null) {
%>

<span style="color: red"> <%=request.getAttribute("message")%> </span>
<br>

<%
    }
%>

<h1>OK</h1>

</body>
</html>
