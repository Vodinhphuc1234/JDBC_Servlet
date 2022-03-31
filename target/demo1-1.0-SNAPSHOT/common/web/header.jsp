

<!-- PRE LOADER -->

<div class="preloader">
    <div class="sk-spinner sk-spinner-wordpress">
        <span class="sk-inner-circle"></span>
    </div>
</div>

<!-- Navigation section -->

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="#">NEURON BLOG</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarScroll">
            <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarScrollingDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Account
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
                        <li><a class="dropdown-item" href="/me">Information</a></li>
                        <li><a class="dropdown-item" href="/me?action=list&page=1&perPage=1">Posts</a></li>
                        <li><hr class="dropdown-divider"></li>
                    </ul>
                </li>

            </ul>
            <form class="d-flex">
                <c:if test="${empty USERMODEL}">
                    <li><a href="login?action=login">Login</a></li>
                </c:if>
                <c:if test="${not empty USERMODEL}">
                    <li class="nav-item"><a class="nav-link" href="me?action=viewInformation">Hello, ${USERMODEL.fullName}</a></li>
                    <li class="nav-item"><a class="nav-link" href="logout?action=logout">Logout</a></li>
                </c:if>
            </form>
        </div>
    </div>
</nav>