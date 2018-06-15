package com.example.demo.test.thread;

import java.util.concurrent.Callable;

/**
 * @author chenjie15
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/5/24 16:21
 */
public class Calculator implements Callable {
    private int op1;
    private int op2;

    public Calculator(int op1, int op2) {
        this.op1 = op1;
        this.op2 = op2;
    }

    @Override
    public Object call() throws Exception {
        return op1 + op2;
    }
}
