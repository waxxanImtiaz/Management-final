<%-- 
    Document   : test
    Created on : Oct 23, 2016, 9:41:53 AM
    Author     : waxxan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% String subj  = (String)session.getAttribute("subjectName"); %>
        <h1>Subject name=<%=subj %></h1>
    </body>
</html>
