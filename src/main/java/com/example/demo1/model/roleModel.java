package com.example.demo1.model;

import java.sql.Timestamp;

public class roleModel extends AbstractModel <roleModel>{

    private String name;
    private String code ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}
