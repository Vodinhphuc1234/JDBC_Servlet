<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 1/27/2022
  Time: 4:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>

<head>
    <title>Bài viết của bạn</title>

</head>

<section id="home" class="main-gallery parallax-section">
    <div class="overlay"></div>
    <div class="container">
        <div class="row">

            <div class="col-md-12 col-sm-12">
                <h1>Your posts</h1>
            </div>

        </div>
    </div>
</section>

<section id="blog">
    <div class="container">
        <div class="row">

            <div class="col-md-offset-1 col-md-10 col-sm-12">

                <c:forEach var="item" items="${posts}">
                    <div class="blog-post-thumb">
                        <div class="blog-post-image">
                            <a href="#">
                                <img src="<c:url value='/template/web/images/blog-image1.jpg'/>" class="img-responsive"
                                     alt="Blog Image">
                            </a>
                        </div>
                        <div class="blog-post-title">
                            <h3><a href="#">${item.title}</a></h3>
                        </div>
                        <div class="blog-post-format">
                        <span><a href="#"><img  src="<c:url value='/template/web/images/author-image1.jpg'/>"
                                               class="img-responsive rounded-circle">${item.createdBy}</a></span>
                            <span><i class="fa fa-date"></i> ${item.createdDate}</span>
                            <span><a href="#"><i class="fa fa-comment-o"></i> 35 Comments</a></span>
                        </div>
                        <div class="blog-post-des">
                            <p>${item.shortDescription}</p>
                            <a href="#" class="btn btn-outline-warning btn-default">Continue Reading</a>


                            <a onclick="doDelete(${item.id})"><button class="btn btn-light">Delete</button></a>
                            <a href="/me?type=posts&action=update&id=${item.id}"><button class="btn btn-light">Update</button></a>
                        </div>
                    </div>
                </c:forEach>
                <nav aria-label="Page navigation example">
                    <ul id="pagination-demo" class="pagination justify-content-center">
                    </ul>
                </nav>

                <form id="paginationForm">
                    <input type="hidden" value='${page}' id="receivedPage"/>
                    <input type="hidden" value='${total}' id="receivedTotal"/>
                    <input type="hidden" value="" id="page" name="page"/>
                    <input type="hidden" value="" id="perPage" name="perPage"/>
                    <input type="hidden" value="1" id="setPerPage"/>
                </form>
            </div>
        </div>
    </div>
</section>

<script>
    function doDelete(id) {
        var _data={}
        _data.ids=[id]
        $.ajax({
            url: "/me",
            type: "DELETE",
            data: JSON.stringify(_data),

            dataType: "application/json",
            success: function (s){
                window.location.href="/me?action=list&page=1&perPage=1&message=success"
            },
        })

}
</script>


