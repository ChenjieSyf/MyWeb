package com.example.demo.test.thread;

import java.util.concurrent.Callable;

/**
 * @author chenjie15
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/5/28 15:37
 */
public class YieldExample{
    public static void main(String[] args)
    {
        Thread producer = new Producer();
        Thread consumer = new Consumer();

        producer.setPriority(Thread.MIN_PRIORITY); //Min Priority
        consumer.setPriority(Thread.MAX_PRIORITY); //Max Priority

        producer.start();
        consumer.start();
    }
}

class Producer extends Thread
{
    @Override
    public void run()
    {
        for (int i = 0; i < 5; i++)
        {
            System.out.println("I am Producer : Produced Item " + i);
            Thread.yield();
        }
    }
}

class Consumer extends Thread
{
    @Override
    public void run()
    {
        for (int i = 0; i < 5; i++)
        {
            System.out.println("I am Consumer : Consumed Item " + i);
            Thread.yield();
        }
    }
}