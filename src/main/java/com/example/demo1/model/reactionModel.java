package com.example.demo1.model;

import java.sql.Timestamp;

public class reactionModel extends AbstractModel <reactionModel>{

    private int type;
    private long userId;
    private long postId;


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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
