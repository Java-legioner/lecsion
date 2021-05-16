<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<style>
    <%@include file="/WEB-INF/css/header.css"%>
</style>
<!------ Include the above in your HEAD tag ---------->

<div id="wrapper" class="animate">
    <nav class="navbar header-top fixed-top navbar-expand-lg  navbar-dark bg-dark">
        <span class="navbar-toggler-icon leftmenutrigger"></span>
        <a class="navbar-brand" href="#">LOGO</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav animate side-nav">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/cabinet.jsp">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/createProduct.jsp">Add Periodical</a>
                </li>
                <li class="nav-item user-bucket-option">
                    <a class="nav-link " href="${pageContext.request.contextPath}/bucket.jsp">Bucket</a>
                </li>
            </ul>
            <ul class="navbar-nav ml-md-auto d-md-flex">
                <li class="nav-item">
                    <button class="nav-link header-logout" style="background-color: #43A047">LogOut</button>
                </li>
            </ul>
        </div>
    </nav>

</div>

<script >
    <%@include file="/WEB-INF/js/header.js"%>
</script>



