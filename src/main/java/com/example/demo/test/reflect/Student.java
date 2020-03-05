package com.example.demo.test.reflect;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Student {

    public int age;

    public String name;

    public String address;

    public Student(Integer age, String name, String address) {
        this.age = age;
        this.name = name;
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name) &&
                Objects.equals(address, student.address);
    }

    @Override
    public int hashCode() {
        return 0;
    }


    public static void main(String[] args) {
        Map<Student,String> map= new HashMap<>();
        Student student = new Student(20,"syf","nj");
        Student student1 = new Student(20,"cj","nj");
        map.put(student,"love");
        System.out.println(map.get(student1));
    }
}
