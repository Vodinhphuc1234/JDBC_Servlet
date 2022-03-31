<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!-- Home Section -->
<head>
    <title>Danh sách bài viết</title>
</head>

<section id="home" class="main-home parallax-section">
    <div class="overlay"></div>
    <div id="particles-js"></div>
    <div class="container">
        <div class="row">

            <div class="col-md-12 col-sm-12">
                <h1>Hello! This is Neuron.</h1>
                <h4>Responsive Blog HTML CSS Website Template</h4>
                <a href="#blog" class="smoothScroll btn btn-default">Discover More</a>
            </div>

        </div>
    </div>
</section>

<!-- Blog Section -->

<section id="blog">
    <div class="container">
        <div class="row">

            <div class="col-md-offset-1 col-md-10 col-sm-12">

                <c:forEach var="item" items="${model.items}">
                    <div class="blog-post-thumb">
                        <div class="blog-post-image">
                            <a href="single-post.html">
                                <img src="<c:url value='/template/web/images/blog-image1.jpg'/>" class="img-responsive"
                                     alt="Blog Image">
                            </a>
                        </div>
                        <div class="blog-post-title">
                            <h3><a href="single-post.html">${item.title}</a></h3>
                        </div>
                        <div class="blog-post-format">
                        <span><a href="#"><img src="<c:url value='/template/web/images/author-image1.jpg'/>"
                                               class="img-responsive img-circle">${item.createdBy}</a></span>
                            <span><i class="fa fa-date"></i> ${item.createdDate}</span>
                            <span><a href="#"><i class="fa fa-comment-o"></i> 35 Comments</a></span>
                        </div>
                        <div class="blog-post-des">
                            <p>${item.shortDescription}</p>
                            <a href="single-post.html" class="btn btn-outline-warning btn-default">Continue Reading</a>
                        </div>
                    </div>
                </c:forEach>
                <nav aria-label="Page navigation example">
                    <ul id="pagination-demo" class="pagination justify-content-center">
                    </ul>
                </nav>

                <form id="paginationForm">
                    <input type="hidden" value='${model.page}' id="receivedPage"/>
                    <input type="hidden" value='${model.total}' id="receivedTotal"/>
                    <input type="hidden" value="" id="page" name="page"/>
                    <input type="hidden" value="" id="perPage" name="perPage"/>
                    <input type="hidden" value="1" id="setPerPage"/>
                </form>
            </div>
        </div>
    </div>
</section>

