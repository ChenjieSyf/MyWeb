package com.example.demo.test.thread;

/**
 * @author chenjie15
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/5/21 16:47
 */
public class MyThread extends Thread {
    private  int count=5;
    @Override
    public synchronized void run() {
        count--;
        System.out.println(Thread.currentThread().getName()+"计算count,值为："+count);

    }
}


