package com.example.demo.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author chenjie15
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/5/17 16:40
 */
public class TracingScript {
    /**
     * 随机数
     */
    private static final Random RANDOM = new Random(1);

    public static void main(String[] args) {
        /* Set<Integer> list = new HashSet<>();
        for (int i = 1; list.size() < 5; i++) {
            list.add(RANDOM.nextInt(i));

        }

        System.out.println(list);*/
        System.out.println((1L << 10));
    }

}
