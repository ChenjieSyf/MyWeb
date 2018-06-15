package com.example.demo.test;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.test.Bar.fillHeap;

/**
 * @author chenjie15
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/5/17 13:55
 */
public class Bar {


    public byte[]placeholder=new byte[64*1024];

    public static void fillHeap(int num)throws InterruptedException{
        List<Bar> list=new ArrayList<Bar>();
        for(int i=0;i<num;i++){
        //稍作延时，令监视曲线的变化更加明显
        Thread.sleep(50);
        list.add(new Bar());
            System.out.println("add obj into list");
        }
        System.gc();
        }
        
    public static void main(String[]args) throws Exception{
        fillHeap(1000);
        System.gc();
    }
}

