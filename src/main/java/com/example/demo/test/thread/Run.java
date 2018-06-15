package com.example.demo.test.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chenjie15
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/5/21 20:04
 */
public class Run {
    public static void main(String[] args) throws Exception{
        ThreadInterrupted thread = new ThreadInterrupted();
        thread.start();
        /*System.out.println("在50秒之内按任意键中断线程!");
        System.in.read();
        System.out.println(thread.getName()+" 准备中断");*/
       /* thread.interrupt();
        System.out.println(thread.getName()+" 异常前，中断状态："+thread.isInterrupted());
        thread.join();
        System.out.println("线程已经退出!");*/

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5,10,60*60, TimeUnit.SECONDS,new
                ArrayBlockingQueue<Runnable>(20));
        int[][] ops = new int[][]{{1,3},{56,56},{99,786},{1234,8986}};
        for (int i = 0; i < ops.length; i++) {
            Calculator calculator = new Calculator(ops[i][0],ops[i][1]);
            Future future = executor.submit(calculator);
            System.out.println(ops[i][0]+" + "+ops[i][1]+"计算结果为："+ future.get());
        }
    }
}
class ThreadInterrupted  extends Thread {
    @Override
     public void run() {

       /* while(!isInterrupted()) {
            try {
                sleep(1000); // 延迟1秒
                System.out.println(getName()+" 中断状态："+isInterrupted());
            } catch (InterruptedException e) {
                System.out.println(getName()+" 被中断："+e.getMessage());
                System.out.println(getName()+" 异常后，中断状态："+isInterrupted());

                //interrupt();
                //System.out.println(getName()+" 再次中断，状态："+isInterrupted());
            }
        }
        System.out.println("任务退出！");*/

             }
 }
