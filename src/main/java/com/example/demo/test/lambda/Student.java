package com.example.demo.test.lambda;

import lombok.SneakyThrows;

public class Student {
    private String name;

    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }



    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String toString() {
        /*System.out.println("Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}');*/
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

   @SneakyThrows
    public static void main(String[] args) {
        String str = null;
        System.out.println(Integer.valueOf(str));
        System.out.println("-----------------hh");
    }

}
