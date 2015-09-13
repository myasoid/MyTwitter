<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Profile</title>
    <meta name="generator" content="Bootply"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <link href="/css/styles.css" rel="stylesheet">
</head>

<body>
<div class="container">
    <div class="row">

    </div>
</div>
<nav class="navbar navbar-default navbar-fixed-top navbar-inverse" role="navigation">
    <div class="navbar-header">
        <a class="navbar-brand" rel="home" href="#">Brand</a>
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
    </div>
    <div class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
            <li><a href="#">Link</a></li>
            <li><a href="#">Link</a></li>
            <li><a href="#">Link</a></li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="#">Action</a></li>
                    <li><a href="#">Another action</a></li>
                    <li class="divider"></li>
                    <li><a href="#">Separated link</a></li>
                    <li class="divider"></li>
                    <li><a href="#">One more separated link</a></li>
                </ul>
            </li>
        </ul>
        <div class="col-sm-3 col-md-3 pull-right">
            <form class="navbar-form" role="search">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search" name="srch-term" id="srch-term">

                    <div class="input-group-btn">
                        <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i>
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</nav>

<div class="container-fluid">

    <!--left-->
    <div class="col-sm-3 col">

        <div class="container usercard">
            <div class="row">
                <div class="span1">
                    <img class="thumbnail" src="//placehold.it/100x100">
                </div>
                <div class="span3">
                    <h5>${user.getName()}</h5>
                    <h5>${user.getLogin()}</h5>
                </div>
            </div>
            <div class="row">
                <div class="span3 offset1">
                    Twits <span class="badge badge-success">${user.getTwits().size()}</span> Following <span
                        class="badge badge-success">${user.getFollowings().size()}</span> Followers <span
                        class="badge badge-success">${user.getFollowers().size()}</span>
                </div>
            </div>
        </div>

    </div>
    <!--/left-->

    <!--center-->
    <div class="col-sm-6">
        <div class="row">
            <ul class="nav nav-tabs" id="UserTabs">
                <li class="nav-link <c:if test="${tab == 'twits'}">active</c:if>" role="presentation"><a href="/${user.getLogin()}">Twits <span
                        class="badge badge-success active">${user.getTwits().size()}</span></a></li>
                <li class="nav-link <c:if test="${tab == 'following'}">active</c:if>" role="presentation"><a href="/${user.getLogin()}/following">Following <span
                        class="badge badge-success">${user.getFollowings().size()}</span></a></li>
                <li class="nav-link <c:if test="${tab == 'followers'}">active</c:if>" role="presentation"><a href="/${user.getLogin()}/followers">Followers <span
                        class="badge badge-success">${user.getFollowers().size()}</span></a></li>
            </ul>

        </div>
        <div class="row">
            <div class="col-xs-12">

                <!--twits-->
                <c:if test = "${tab=='twits'}">
                <c:forEach items="${user.getTwits()}" var="twit">
                    <h2>${twit.getOwner().getLogin()}</h2>

                    <p>${twit.getText()}</p>

                    <p class="lead">
                        <button class="btn btn-default">Read More</button>
                    </p>
                    <p class="pull-right"><span class="label label-default">keyword</span> <span
                            class="label label-default">tag</span> <span class="label label-default">post</span></p>
                    <ul class="list-inline">
                        <li><a href="#">${twit.getDateCreated()}</a></li>
                            <%--<li><a href="#"><i class="glyphicon glyphicon-comment"></i> 2 Comments</a></li>--%>
                            <%--<li><a href="#"><i class="glyphicon glyphicon-share"></i> 14 Shares</a></li>--%>
                    </ul>
                    <hr>
                </c:forEach>
                </c:if>
                <!--/twits-->

                <!--following-->
                <c:if test = "${tab=='following'}">
                    <div class="row">
                        <c:forEach items="${user.getFollowings()}" var="user">
                        <div class="col-sm-4">
                            <div class="row">
                                <div class="span1">
                                    <img class="thumbnail" src="//placehold.it/100x100">
                                </div>
                                <div class="span3">
                                    <h5>${user.getName()}</h5>
                                    <h5>
                                        <a href="/${user.getLogin()}" class="href">${user.getLogin()}</a>
                                    </h5>
                                </div>
                            </div>
                            <div class="row">
                                <div class="span3 offset1">
                                    Twits <span class="badge badge-success">${user.getTwits().size()}</span> Following <span
                                        class="badge badge-success">${user.getFollowings().size()}</span> Followers <span
                                        class="badge badge-success">${user.getFollowers().size()}</span>
                                </div>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                </c:if>
                <!--/following-->

                <!--followers-->
                <c:if test = "${tab=='followers'}">
                    <div class="row">
                        <c:forEach items="${user.getFollowers()}" var="user">
                            <div class="col-sm-4">
                                <div class="row">
                                    <div class="span1">
                                        <img class="thumbnail" src="//placehold.it/100x100">
                                    </div>
                                    <div class="span3">
                                        <h5>${user.getName()}</h5>
                                        <h5>${user.getLogin()}</h5>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="span3 offset1">
                                        Twits <span class="badge badge-success">${user.getTwits().size()}</span> Following <span
                                            class="badge badge-success">${user.getFollowings().size()}</span> Followers <span
                                            class="badge badge-success">${user.getFollowers().size()}</span>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </c:if>
                <!--/followers-->

            </div>
        </div>
        <%--<hr>--%>

    </div>
    <!--/center-->

    <!--right-->
    <div class="col-sm-3">
        <h2>Side</h2>

        <%--<div class="panel panel-default">--%>
        <%--<div class="panel-heading">Title</div>--%>
        <%--<div class="panel-body">Sed ac orci quis tortor imperdiet venenatis. Duis elementum auctor accumsan. Aliquam--%>
        <%--in felis sit amet augue.--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--<hr>--%>
        <%--<div class="panel panel-default">--%>
        <%--<div class="panel-heading">Title</div>--%>
        <%--<div class="panel-body">Content here..</div>--%>
        <%--</div>--%>
        <%--<hr>--%>
        <%--<div class="panel panel-default">--%>
        <%--<div class="panel-heading">Title</div>--%>
        <%--<div class="panel-body">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis pharetra varius quam--%>
        <%--sit amet vulputate. Quisque mauris augue, molestie tincidunt condimentum vitae, gravida a libero. Aenean--%>
        <%--sit amet felis dolor, in sagittis nisi. Sed ac orci quis tortor imperdiet venenatis. Duis elementum--%>
        <%--auctor accumsan. Aliquam in felis sit amet augue.--%>
        <%--</div>--%>
        <%--</div>--%>
        <%--<hr>--%>
        <div class="panel panel-default">
            <div class="panel-heading">Title</div>
            <div class="panel-body">Content here..</div>
        </div>
        <hr>
    </div>
    <!--/right-->
    <hr>
</div>
<!--/container-fluid-->

<!-- script references -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>

</html>