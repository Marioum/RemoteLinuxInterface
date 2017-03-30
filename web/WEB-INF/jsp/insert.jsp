<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SSH Connection</title>
    </head>
    <body>
<div class="row">

            <center><h2 class="page-header" style="margin: 40px 402px 20px;">SSH Connection</h2></center>
        </div>
        
        <div class="row">
            <div class="col-lg-2"></div>
            <div class="col-lg-8">
                <div class="row" style="padding-top: 80px;"></div>
                <form:form class="form-signin" commandName="insertForm" method="POST" action="resultat.htm">
                    <center><h3 class="form-signin-heading">Enter your Command</h3></center>
                    <input type="text" class="form-control" placeholder="Command" name="command" /><br /><br />
                    <button class="btn btn-lg btn-primary btn-block" type="submit" value="Submit">Execute</button>
                </form:form>
                    <h4><c:out value="${resultat}"/></h4>
                    <h4><c:out value="${error}"/></h4>
                    
            </div>
        <div class="col-lg-2"></div>
        </div>
    </body>
</html>
