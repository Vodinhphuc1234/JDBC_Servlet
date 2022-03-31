package com.example.demo1.model;

import java.sql.Timestamp;

public class commentModel extends AbstractModel <commentModel>{

    private String  content;
    private long userId;
    private long postId;



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }
}
