package com.example.demo.test.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenjie15
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/5/21 16:50
 */
public class ThreadRun {
    public static void main(String[] args) throws Exception{
        /*MyThread myThread = new MyThread();
        Thread a = new Thread(myThread,"A");
        Thread b = new Thread(myThread,"B");
        Thread c = new Thread(myThread,"C");
        Thread d = new Thread(myThread,"D");
        Thread e = new Thread(myThread,"E");
        System.out.println(a.isAlive());
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
        System.out.println(a.isAlive());*/
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        int size =2;
        int i=0;
        while ( i < list.size()) {
            if(list.size()-i<=size) {
                System.out.println(list.subList(i,list.size()));
            }else {
                System.out.println(list.subList(i,i+size));

            }
            i+=size;
        }
        //System.out.println(list.subList(0,list.size()));

      //  testInterrupt();
    }

    public  static void testInterrupt() throws Exception{
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(1000);
        System.out.println("------"+Thread.currentThread().getName());
        myThread.interrupt();
        System.out.println(myThread.isInterrupted());
        System.out.println(myThread.isInterrupted());

    }
}
