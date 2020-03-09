package com.example.demo.test.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RequestInfo {
    private String name;

    private String ownerName;
    //计划服务端发布日期
    private String planDeployServerTime;
}
