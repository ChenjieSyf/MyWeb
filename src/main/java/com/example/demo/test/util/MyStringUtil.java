package com.example.demo.test.util;

import com.example.demo.test.entity.ExcelData;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.StringWriter;
import java.util.List;
import java.util.Map;

public class MyStringUtil {

    @SneakyThrows
    public static String freemarkerProcess(Map input, String templateStr) {
        StringTemplateLoader stringTemplateLoader = new StringTemplateLoader();
        String template = "context";
        stringTemplateLoader.putTemplate(template, templateStr);
        Configuration configuration = new Configuration();
        configuration.setTemplateLoader(stringTemplateLoader);

        Template templateCon = configuration.getTemplate(template);
        StringWriter stringWriter = new StringWriter();
        templateCon.process(input, stringWriter);
        return stringWriter.toString();

    }


}
