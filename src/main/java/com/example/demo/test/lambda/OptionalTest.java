package com.example.demo.test.lambda;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        Student student = null;
        System.out.println(Optional.ofNullable(student).map(Student::getName).orElse("default"));

        test((s)->{
            System.out.println("yes,"+s);
        });
    }

    public static void test(MyFunctionInterface myFunctionInterface) {
        myFunctionInterface.myPrint("hello");
    }
}


