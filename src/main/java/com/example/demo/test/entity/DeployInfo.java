package com.example.demo.test.entity;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class DeployInfo {

    private String appName;

    private List<RequestInfo> reqList;;

}
