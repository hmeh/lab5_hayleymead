<%-- 
    Document   : login
    Created on : 14-Jun-2022, 12:14:31 PM
    Author     : Hayle
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="get" action="login_form">
            <label>Username: </label>
            <input type="text" name="username" value="">
            <br>
            <label>Password: </label>
            <input type="text" name="password" value="">
            <br>
            <input type="submit" name="login" value="login">
            
        </form>
    </body>
</html>
