package com.example.demo.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author chenjie15
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/5/17 14:54
 */
public class DeadLock {

    /**
     *线程死循环演示
     */
    public static void createBusyThread(){
        Thread thread=new Thread(new Runnable(){
            @Override
            public void run(){
                while (true) {

                }
            }
        },"testBusyThread");
        thread.start();
    }
    /**
     *线程锁等待演示
     */
    public static void createLockThread(final Object lock){
        Thread thread=new Thread(new Runnable(){
            @Override
            public void run(){
                synchronized(lock){
                    try{
                        lock.wait();
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        },"testLockThread");
        thread.start();
    }
   /* public static void main(String[]args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        createBusyThread();
        br.readLine();
        Object obj=new Object();
        createLockThread(obj);
    }*/

    /**
     *线程死锁等待演示
     */
    static class SynAddRunalbe implements Runnable{
        int a,b;
        public SynAddRunalbe(int a,int b){
            this.a=a;
            this.b=b;
        }
        @Override
        public void run(){
            synchronized(Integer.valueOf(a)){
                synchronized(Integer.valueOf(b)){
                    System.out.println(a+b);
                }
            }
        }
    }
    public static void main(String[]args){
        for(int i=0;i<100;i++){
            new Thread(new SynAddRunalbe(1,2)).start();
            new Thread(new SynAddRunalbe(2,1)).start();
        }



    }
    
}
