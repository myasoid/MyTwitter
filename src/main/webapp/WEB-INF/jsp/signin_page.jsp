<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Sign in</title>

    <!-- Bootstrap -->
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container ">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-body">
                    <h5 class="text-center">
                        SIGN IN</h5>

                    <c:url value="/j_spring_security_check" var="loginUrl" />
                    <form class="form form-signin" role="form" enctype="multipart/form-data" method="post" action="${loginUrl}">
                        <div class="form-group">
                            <div class="input-group">
                                    <span class="input-group-addon"><span class="fa fa-twitter"></span>
                                    </span>
                                <input type="text" class="form-control" name="j_username" placeholder="login"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                                <input type="password" class="form-control" name="j_password" placeholder="Password"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <input id="submit" name="submit" type="submit" value="Submit"
                                   class="btn btn-primary btn-block" role="button">
                        </div>
                    </form>

                    <%--<div class="container" style="width: 300px;">--%>
                        <%--<c:url value="/j_spring_security_check" var="loginUrl" />--%>
                        <%--<form action="${loginUrl}" method="post">--%>
                            <%--<h2 class="form-signin-heading">Please sign in</h2>--%>
                            <%--<input type="text" class="form-control" name="j_username" placeholder="Email address" required autofocus value="colibri">--%>
                            <%--<input type="password" class="form-control" name="j_password" placeholder="Password" required value="1234">--%>
                            <%--<button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>--%>
                        <%--</form>--%>
                    <%--</div>--%>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<%--<script src="js/bootstrap.min.js"></script>--%>
</body>

</html>