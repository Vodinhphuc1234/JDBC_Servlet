<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<head>
    <title>Đăng kí</title>
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
                <h1>Register Page</h1>
            </div>

        </div>
    </div>
</section>
<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100 p-t-85 p-b-20">
            <form class="login100-form validate-form m-b-85" method="post">
					<span class="login100-form-title p-b-70">
						Register Form
					</span>

                <c:if test="${not empty message}">
                    <div class="alert alert-${alert} m-t-30" role="alert">
                            ${message}
                    </div>
                </c:if>

                <div class="wrap-input100 validate-input m-t-50 m-b-35" data-validate="Enter fullName">
                    <input class="input100" type="text" name="fullName">
                    <span class="focus-input100" data-placeholder="Fullname"></span>
                </div>

                <div  id="check-username"></div>
                <div class="wrap-input100 validate-input m-t-50 m-b-35" data-validate="Enter username">
                    <input class="input100" id="userName" type="text" name="userName" onkeyup="checkUsername()">
                    <span class="focus-input100" data-placeholder="Username"></span>
                </div>

                <div id="check-password"></div>
                <div class="wrap-input100 validate-input m-b-50" data-validate="Enter password">
                    <input class="input100" id="password" type="password" name="password" onkeyup="checkPassLength()">
                    <span class="focus-input100" data-placeholder="Password"></span>
                </div>

                <div id="check-confirm-password"></div>
                <div class="wrap-input100 validate-input m-b-50" data-validate="Enter password again">
                    <input class="input100" id="confirm-password" type="password"  onkeyup="checkConfirmPass()">
                    <span class="focus-input100" data-placeholder="Re-entered Password"></span>
                </div>

                <div class="wrap-input100 validate-input m-t-50 m-b-35" data-validate="Enter email">
                    <input class="input100" type="email" name="email">
                    <span class="focus-input100" data-placeholder="Email"></span>
                </div>

                <input type="hidden" name="action" value="signup">

                <div class="container-login100-form-btn">
                    <button type="submit" id="btn-submit" class="login100-form-btn" disabled>
                        Register
                    </button>
                </div>

            </form>
        </div>
    </div>
</div>


<div id="dropDownSelect1"></div>

<script>
    function checkConfirmPass(){
        var pass1= $('#password').val()
        var pass2= $('#confirm-password').val()

        if (pass1!==pass2){
            document.getElementById("check-confirm-password").innerHTML="Password is not matching"
            document.getElementById("check-confirm-password").style.color="red"
            document.getElementById("btn-submit").disabled=true
        }else {
            document.getElementById("check-confirm-password").innerHTML=""
            document.getElementById("btn-submit").disabled=false
        }
    }
    function checkPassLength(){
        var pass= $('#password').val()

        if (pass.length < 16){
            document.getElementById("check-password").innerHTML="Password must be longer than 16 characters"
            document.getElementById("check-password").style.color="red"
            document.getElementById("btn-submit").disabled=true
        }else {
            document.getElementById("check-password").innerHTML=""
            document.getElementById("btn-submit").disabled=false
        }
    }

    function checkUsername(){
        var username= $('#userName').val()

        if (username.length < 10){
            document.getElementById("check-username").innerHTML="Username must be longer than 10 characters"
            document.getElementById("check-username").style.color="red"
            document.getElementById("btn-submit").disabled=true
        }else {
            document.getElementById("check-username").innerHTML=""
            document.getElementById("btn-submit").disabled=false
        }
    }
</script>

</body>
