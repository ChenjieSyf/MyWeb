package com.example.demo.test.http;

import com.alibaba.fastjson.JSON;
import com.example.demo.test.entity.DeployInfo;
import com.example.demo.test.entity.ExcelData;
import com.example.demo.test.entity.MbResult;
import com.example.demo.test.entity.RequestInfo;
import com.example.demo.test.excel.Maker;
import com.example.demo.test.util.MyStringUtil;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;

public class TestHttp {
    //
    private static final String URL_TEMPLATE = "http://dmpt.ymmoa.com/publish/getPublishDeployByPublishPlanId?publishPlanId=${id}&type=1";
    private static final String SPLITOR = ",";


    public static void main(String[] args) throws Exception {
        String idList = "1009,1053,1054,1074,1075";
        String cookie = "";
        String[] ids = idList.split(SPLITOR);
        List<String> urls = new ArrayList<>();
        Map<String, String> param = new HashMap<>(1);
        for (String id : ids) {
            param.put("id", id);
            String url = MyStringUtil.freemarkerProcess(param, URL_TEMPLATE);
            urls.add(url);
        }
        Map<String, List<ExcelData>> dataMap = getDeployData(urls, cookie);
        Maker.writeExcel(dataMap);
    }


    private static Map<String, List<ExcelData>> getDeployData(List<String> urls, String cookie) {
        if (CollectionUtils.isEmpty(urls)) {
            return null;
        }
        Map<String, List<ExcelData>> dataMap = new HashMap<>(16);
        urls.forEach(url -> {
            Map<String, String> param = new HashMap<>(1);
            param.put("Cookie", cookie);
            String result = HttpClientUtil.getData(url, param);
            if (StringUtils.isEmpty(result)) {
                return;
            }
            MbResult mbResult = JSON.parseObject(result, MbResult.class);
            List<DeployInfo> deployInfos = mbResult.getData();
            deployInfos.forEach(deployInfo -> {
                String appName = deployInfo.getAppName();
                if (!appName.contains("cargo")) {
                    return;
                }
                List<RequestInfo> requestInfos = deployInfo.getReqList();
                requestInfos.forEach(requestInfo -> {

                    if (!StringUtils.isEmpty(requestInfo.getPlanDeployServerTime())) {
                        long time = Long.valueOf(requestInfo.getPlanDeployServerTime());
                        ExcelData excelData = new ExcelData();
                        excelData.setAppName(appName);
                        excelData.setPublishContext(requestInfo.getName());
                        excelData.setOwnerName(requestInfo.getOwnerName());
                        excelData.setPublishDate(time);
                        if (dataMap.get(appName) == null) {
                            List<ExcelData> excelDataList = new ArrayList<>();
                            dataMap.put(appName, excelDataList);
                        }
                        dataMap.get(appName).add(excelData);

                    }
                });
            });
        });

        //进行排序
        dataMap.forEach((k, v) -> {
            if (!CollectionUtils.isEmpty(v)) {
                Collections.sort(v);
            }
        });

        return dataMap;
    }


}
