package com.example.demo.test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OnDutyDateGenerator {

    public static final String NEXT_LINE = "\t";

    public static final Map<String, String> PHONE_MAP = new HashMap<String, String>() {{
        put("陈强", "15251840922");
        put("陈杰", "15921753783");
        put("陈洪冰", "13851762382");
        put("张凯翔", "17366095026");
        put("周胡瑾", "15165171262");
        put("黄浚源", "18601405886");
        put("许欣欣", "15250997306");
        put("陈凯钧", "18362939967");
        put("王汪送", "18262636563");
        put("吴利民", "13805196147");
        put("李爱武", "15105162191");
        put("邵康伟", "18913313087");
        put("李志明", "18340312781");
    }};

    public static final List<String> NAME_ARRAY = Arrays.asList(
            new String[]{"陈杰", "黄浚源", "周胡瑾", "王汪送", "许欣欣", "陈凯钧", "陈强", "陈洪冰"
                    , "吴利民", "邵康伟", "张凯翔", "李爱武", "李志明"});


    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2019, 12, 30);
        int index = 0;
        for (String name : NAME_ARRAY) {
            LocalDate startDate = localDate.plusDays(index * 7);
            LocalDate endDate = startDate.plusDays(6);
            System.out.println(generateCell(index, name, PHONE_MAP.get(name).toString(), startDate.toString(), endDate.toString()));
            index++;
        }
    }

    public static String generateCell(int index, String name, String phone, String startDate, String endDate) {
        return (index + 1) + NEXT_LINE + name + NEXT_LINE + phone + NEXT_LINE + startDate + "~" + endDate;
    }
}
