<%--
  Created by IntelliJ IDEA.
  User: Phuoc
  Date: 11/29/2023
  Time: 3:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <title>Banking</title>
</head>
<body>
<div class="container" style="margin-top: 150px">
    <div class="card">
        <div class="card-header">
            <h2>Banking System</h2>
        </div>
        <div class="card-body">
            <div class="row">
                <div class="col-2">
                    <c:set var="username" value="${username}"/>
                    <h2><c:out value="${username}"/></h2>
                </div>
                <div class="col-10">
                    <form action="transfer?username=<c:out value="${username}"/>" method="post">
                        <div class="my-2">
                            <c:set var="balance" value="${balance}"/>
                            <label for="balance" class="form-label">Your Balance</label>
                            <input id="balance" value="<c:out value="${balance}"/>" class="form-control" readonly>
                        </div>
                        <div class="my-2">
                            <label for="amount" class="form-label">Enter Amount</label>
                            <c:set var="err" value="${err}"/>
                            <span style="color: red"><c:out value="${err}"/></span>
                            <input id="amount" type="number" name="amount" class="form-control">
                        </div>
                        <div class="my-2">
                            <label for="account">Select account to transfer</label>
                            <select id="account" class="form-select" name="account">
                                <option selected>Select an account</option>
                                <c:forEach var="i" items="${accountList}">
                                    <option value="${i.account}">${i.account}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="my-2">
                            <label for="note" class="form-label">Transaction note</label>
                            <textarea id="note" rows="3" class="form-control" name="note"></textarea>
                        </div>
                        <div class="my-2">
                            <button type="submit" class="btn btn-primary">Transfer</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
