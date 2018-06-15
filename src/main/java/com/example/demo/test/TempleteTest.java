package com.example.demo.test;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenjie15
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/6/7 10:51
 */
public class TempleteTest {

    public static void main(String[] args) {
        try {
            Map map = new HashMap();
            map.put("name", "张三");
            map.put("money", 10.155);
            map.put("point", 10);
            map.put("time", "2018-06-07 11:11:11");
            Template template = new Template("","${time},您好${name}，晚上好！您目前余额：${money?string(\"#.##\")}元，积分：${point}",
                    new
                    Configuration(new Version("2.3.23")));
            StringWriter result = new StringWriter();
            template.process(map, result);
            System.out.println(result.toString());
            //您好张三，晚上好！您目前余额：10.16元，积分：10
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
