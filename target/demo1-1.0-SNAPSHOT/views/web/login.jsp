<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<head>
    <title>Đăng nhập</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
</head>
<body>
<section id="home" class="main-gallery parallax-section">
    <div class="overlay"></div>
    <div class="container">
        <div class="row">

            <div class="col-md-12 col-sm-12">
                <h1>Login Page</h1>
            </div>

        </div>
    </div>
</section>
<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100 p-t-85 p-b-20">
            <form class="login100-form validate-form" method="post">
					<span class="login100-form-title p-b-70">
						Welcome
					</span>
                <span class="login100-form-avatar">
						<img src="<c:url value="/template/web/images/login.png"/>" alt="AVATAR">
					</span>

                <c:if test="${not empty message}">
                    <div class="alert alert-${alert} m-t-30" role="alert">
                        ${message}
                    </div>
                </c:if>

                <div class="wrap-input100 validate-input m-t-50 m-b-35" data-validate="Enter username">
                    <input class="input100" type="text" name="userName">
                    <span class="focus-input100" data-placeholder="Username"></span>
                </div>

                <div class="wrap-input100 validate-input m-b-50" data-validate="Enter password">
                    <input class="input100" type="password" name="password">
                    <span class="focus-input100" data-placeholder="Password"></span>
                </div>

                <input type="hidden" name="action" value="login">

                <div class="container-login100-form-btn">
                    <button type="submit" class="login100-form-btn">
                        Login
                    </button>
                </div>

                <ul class="login-more p-t-190">
                    <li class="m-b-8">
							<span class="txt1">
								Forgot
							</span>

                        <a href="#" class="txt2">
                            Username / Password?
                        </a>
                    </li>

                    <li>
							<span class="txt1">
								Don’t have an account?
							</span>

                        <a href="/signup?action=signup" class="txt2">
                            Sign up
                        </a>
                    </li>
                </ul>
            </form>
        </div>
    </div>
</div>


<div id="dropDownSelect1"></div>


</body>
