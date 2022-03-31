package com.example.demo1.paging;

import com.example.demo1.service.IPostService;

import javax.inject.Inject;

public class pageRequest implements Pagable{
    private Integer page;
    private Integer perPage;

    private String sortBy;
    private  String sortName;
    private Integer total;

    public pageRequest(Integer page, Integer perPage, String sortBy, String sortName, Integer total) {
        this.page = page;
        this.perPage = perPage;
        this.sortBy = sortBy;
        this.sortName = sortName;
        this.total = total;
    }

    @Override
    public Integer getOffset() {
        return (page-1)*perPage;
    }

    @Override
    public Integer getLimit() {
        int totalPost=total;
        return (totalPost-getOffset()<perPage) ? totalPost : getOffset()+perPage;
    }

    @Override
    public String getSortBy() {
        return sortBy;
    }

    @Override
    public String getSortName() {
        return sortName;
    }

    @Override
    public Integer getPage() {
        return page;
    }

    @Override
    public Integer getPerPage() {
        return perPage;
    }

    @Override
    public Integer getTotal() {
        return total;
    }


}
