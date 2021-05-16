
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">


    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

    <style>
        <%@include file="/WEB-INF/css/login.css"%>
    </style>



    <title>i-store</title>
</head>
<body>


<div class="login-page">
    <div class="form">
        <form class="register-form">
            <input class="firstName" type="text" placeholder=" first name"/>
            <input class="lastName" type="text" placeholder=" last name"/>
            <input class="email" type="text" placeholder="email address"/>
            <input class="password" type="password" placeholder="password"/>
            <input class="cpassword" type="password" placeholder="confirm password"/>
            <button class="register">create</button>
            <p class="message">Already registered? <a href="#">Sign In</a></p>
        </form>
        <form class="login-form">
            <input class="email" type="text" placeholder="email address"/>
            <input class="password" type="password" placeholder="password"/>
            <button class="login">login</button>
            <p class="message">Not registered? <a href="#">Create an account</a></p>
        </form>
    </div>
    <div class="alert alert-success alert-dismissible fade show" role="alert">
        <b>Success!</b> You are registered.
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script >
    <%@include file="/WEB-INF/js/login.js"%>
</script>

</body>
</html><body>







