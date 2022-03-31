package com.example.demo1.paging;

public interface Pagable {
    Integer getOffset();
    Integer getLimit();
    String getSortBy();
    String getSortName();
    Integer getPage();
    Integer getPerPage();
    Integer getTotal();
}
