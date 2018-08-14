<%--
  Created by IntelliJ IDEA.
  User: Dan's Guest
  Date: 8/6/2018
  Time: 9:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="script_refs.jsp" />
    <title>Not Found</title>

    <link rel="stylesheet" type="text/css" href="/css/errorPage.css">
    <link rel="stylesheet" type="text/css" href="/css/profilecss.css">
</head>
<body>

    <jsp:include page="navbar_full.jsp" />

    <div class="col py-3">
        <div class="body_wrapper">
            <%= (String)request.getAttribute("error") %>
        </div>
    </div>

    <jsp:include page="footer.jsp" />

</body>
</html>
