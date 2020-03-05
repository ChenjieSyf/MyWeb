package com.example.demo.test.reflect;


import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CleanFieldUtil {

    public static <T> void cleanField(T t, List<String> needFieldNames) {
        Field[] fields = t.getClass().getDeclaredFields();

        Arrays.asList(fields).forEach(field -> {
            if (!needFieldNames.contains(field.getName())) {
                try {
                    field.setAccessible(true);
                    field.set(t, null);
                }catch (Exception e) {
                e.printStackTrace();
                }

            }
        });


    }

    public static void main(String[] args) {
        Student student =  new Student(12,"cj","sd");
        List<String> fields =  new ArrayList<>();
        fields.add("name");
        cleanField(student,fields);
         System.out.println(student);
    }
}
