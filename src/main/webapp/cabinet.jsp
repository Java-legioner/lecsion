<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Cabinet</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>
<div class="container-fluid">
    <div class="row">
        <div id="productsCards"></div>
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
<script>
    <%@include file="WEB-INF/js/cabinet.js"%>
</script>
</body>
</html>
