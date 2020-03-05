package com.example.demo.test.lambda;

import com.example.demo.test.lambda.inerface.CheckStudent;
import com.example.demo.test.lambda.inerface.PrintAge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaTest {

    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("陈杰", 19),
                new Student("赵杰", 21),
                new Student("孙杰", 30),
                new Student("陈独秀", 35)
        );

       /* printAllChen(students, (student -> (student.getName().startsWith("陈"))),
                (student -> {
                    System.out.println(student.getName() + ":" + student.getAge());
                }));*/

       /* printAllChenDefault(students, (student -> (student.getName().startsWith("陈"))),
                (student -> {
                    System.out.println(student.getName() + ":" + student.getAge());
                }));*/

     /*  students.stream().filter((student -> student.getName().startsWith("陈"))).forEach(student -> {
           System.out.println(student.getName() + "steam:" + student.getAge());
       });*/


        /*  students.stream().filter((student -> student.getName().startsWith("陈"))).forEach(Student::toString);*/

       /* students.stream().forEach(student -> {
            Optional.ofNullable(student).ifPresent(System.out::println);
        });*/

        /*students.stream().forEach(student -> {
            Student student1 = Optional.ofNullable(student).orElse(new Student("default",18));
            System.out.println(student1.toString());
        });*/

        //map的使用
       /* List<Integer> list = new ArrayList<>();
        students.stream().map((student -> Optional.ofNullable(student).orElse(new Student("default",0)).getAge())).collect(Collectors.toList());
*/
        //reduce的用法
        Integer i = students.stream().map(student -> Optional.ofNullable(student).orElse(new Student("default",0)).getAge() * 3).reduce((s, v) -> s += v).get();
        String str = Stream.of("C", "J", "Z", "L", "L").reduce("", String::concat);
        System.out.println(str);

        Student s = new Student();
        Optional.ofNullable(s).orElse(new Student());

    }

    public static void printAllChen(List<Student> students, CheckStudent checkStudent, PrintAge printAge) {
        for (Student s : students) {
            if (checkStudent.startWhite(s)) {
                printAge.print(s);
            }
        }
    }

    public static void printAllChenDefault(List<Student> students, Predicate<Student> predicate, Consumer<Student> consumer) {

       /* for (Student s : students) {
            if (predicate.test(s)) {
               consumer.accept(s);
            }
        }*/

        students.forEach((student -> {
            if (predicate.test(student)) {
                consumer.accept(student);
            }
        }));
    }


}
