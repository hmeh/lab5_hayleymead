<%-- 
    Document   : home
    Created on : 14-Jun-2022, 12:14:00 PM
    Author     : Hayle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <h2>Hello ${username_display} </h2>
        <a href="login?logout">Log Out</a>
        <p>${logout_success}</p>
    </body>
</html>
