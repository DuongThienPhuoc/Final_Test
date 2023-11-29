<%--
  Created by IntelliJ IDEA.
  User: Phuoc
  Date: 11/29/2023
  Time: 3:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <title>Login</title>
</head>
<body>
<div id="login-page" class="row" style="margin-top: 150px">
    <div class="col-md-4"></div>
    <div id="login-form" class="col-md-4 col-12 mx-1">
        <div class="card">
            <div class="card-header py-3">Please Sign In</div>
            <div class="card-body p-1">
                <form action="login" method="post">
                    <div class="my-2">
                        <label for="username"></label>
                        <input id="username" type="text" class="form-control" required placeholder="User Name" name="username" value="<c:out value="${username}"/>">
                        <span class="ms-2" id="usernameError" style="color: red"></span>
                    </div>
                    <div class="my-2">
                        <label for="password"></label>
                        <input id="password" type="password" class="form-control" required placeholder="Password" name="password" value="<c:out value="${password}"/>">
                        <span class="ms-2" id="passwordError" style="color: red"></span>
                    </div>
                    <div class="my-2">
                        <label for="remember"></label>
                        <input class="me-1" type="checkbox" name="remember" id="remember"><span>Remember Me</span>
                    </div>
                    <span style="color: red"><c:out value="${err}"/></span>
                    <div class="my-2">
                        <button class="btn btn-success w-100" type="submit">Login</button>
                    </div>
                    <div class="my-2">
                        <a class="register-link" href="#">Click here to Register</a>
                    </div>
                </form>
            </div>
        </div>

    </div>
    <div class="col-md-4"></div>
</div>
</body>
</html>
