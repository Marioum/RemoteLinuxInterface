<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SSH Connection</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="../../ressources/css/Content/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="../../ressources/css/Content/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
        <link href="../../ressources/css/Content/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
        <script src="Scripts/kendo/2016.2.714/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="row">

            <center><h2 class="page-header" style="margin: 40px 402px 20px;">SSH Connection</h2></center>
        </div>
        
        <div class="row">
        <div class="col-lg-2"></div>
        
            
            <div class="col-lg-8">
                <div class="row" style="padding-top: 80px;"></div>
                <form:form class="form-signin" commandName="submitForm" method="POST" action="insert.htm">
                    <center><h3 class="form-signin-heading">Please Sign In</h3></center>
                    <input type="text" class="form-control" placeholder="IP Address" name="host" /><br /><br />
                    <input type="text" class="form-control" placeholder="Login" name="username" /><br /><br />
                    <input type="password" class="form-control" placeholder="Password" name="password"/><br /><br />
                    <button class="btn btn-lg btn-primary btn-block" type="submit" value="Submit">Connection</button>
                </form:form>
                    <h4><c:out value="${noconnexion}"/></h4>
            </div>
        <div class="col-lg-2"></div>
        </div>

    </body>
</html>
