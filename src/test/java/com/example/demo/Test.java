package com.example.demo;

import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenjie15
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/5/14 9:42
 */
public class Test {
    public long myIndex = 203984756L;

    public static void main(String[] args) {
        /*List<Test> infinityList = new ArrayList<>();
        while (true) {
            infinityList.add(new Test());
        }*/
        // new Test().loopCreateForOOS();
       // new Test().ConstantPoolOOM();
       // new Test().CGLibOOM();
        String str = "";
        System.out.println(str=="");
    }

    public void loopCreateForOOS() {
        new Test().loopCreateForOOS();
        ;
    }

    public void ConstantPoolOOM() {
        List<String> stringList = new ArrayList<>();
        int i = 0;
        while (true) {
            stringList.add(new String("myString" + i).intern());
            i++;
        }
    }

    public void CGLibOOM() {
        List<String> stringList = new ArrayList<>();
        int i = 0;
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(Test.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MyMethodInterceptor() {
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    return proxy.invokeSuper(obj, args);
                }
            });
        }
    }
}
class MyMethodInterceptor implements Callback {

}