package com.example.demo.test.entity;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class MbResult {
    private int result;

    private Integer errorCode;

    private String errorMsg;

    private List<DeployInfo> data;
}
