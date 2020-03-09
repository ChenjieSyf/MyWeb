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
    private static final String URL_TEMPLATE = "";
    private static final String SPLITOR = ",";


    public static void main(String[] args) throws Exception{
        String idList = "1053,1009,1084,987,975";
        String cookie = "qa_passport=aBCm4QdFLAg6VLE5yo4JQPGE-cFs_FtstmKqq0qJuAIUyBbBLykzGqKd10KCv40lXhcH4mtZNAnzpFkpU14uakSIB3V-dT-RAh63QMHN4XMD2X8zmWLJ2qE1n6YyK1VB1o7Mv2RONoNmxmLEiis0_CRRfj9JQO0_wrZN2rihP-s; ymmoa_passport=XQxtaU7czIj9aXl8DEIFIdZ2Q5s1UBukoYyvfdEQbuI7hdSFL5CTOFIW9ZOmfCYdNNzCJBxJJ2EE9HkD2n_xUXVgemcEUSDAAAutMVUzeU8o1dGxd02O2AVxowbxJYnlQUsbu7WwuN7LvBppRlwOdVkcZ9X6VBFZUDIWNLFwykY; _ssoSeed=1583718397289; dev_passport=PzlnFgpIwa3RB_wxU4bRH0icGqgWI49y1YpdBtzPaeXER6yD7qKBqmnGc7FCtJbmTmUZAVslwCPYKV5BPdQ3fcUYi6e7fyrYf_NfSibXnWCuLVyTKc82ap7HQgKD5yHEwVYt9uwSsbtzjTS0CdX82xhoi-NakL0nlzdbKhP6Ezo; ymmoa_user={%22name%22:%22%E8%AF%B7%E4%B8%8D%E8%A6%81%E4%BD%BF%E7%94%A8%E6%AD%A4%20Cookie%22%2C%22avatarUrl%22:%22%22%2C%22departmentName%22:%22%E8%AF%B7%E4%B8%8D%E8%A6%81%E4%BD%BF%E7%94%A8%E6%AD%A4%20Cookie%22%2C%22id%22:9999999%2C%22jobNumber%22:%22Y9999999%22}";
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
