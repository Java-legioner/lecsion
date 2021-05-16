<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create product</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container-fluid">
    <div class="row">
        <form class="createProduct">
            <div class="form-group">
                <input type="text" class="form-control productName"
                       placeholder="enter product name">
            </div>
            <div class="form-group">
                <input type="text" class="form-control productDescription"
                       placeholder="enter product description">
            </div>
            <div class="form-group">
                <input type="number" class="form-control productPrice"
                       placeholder="enter product price">
            </div>

            <button class="btn btn-primary createProduct">Submit</button>
        </form>
    </div>
</div>


<jsp:include page="footer.jsp"></jsp:include>
<script>
    <%@include file="WEB-INF/js/serverCalls.js"%>
</script>
</body>
</html>
