package com.example.demo.test.arithmetic;

import java.util.Comparator;

/**
 * @author chenjie15
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description:
 * <? super T>表示包括T在内的任何T的父类，<? extends T>表示包括T在内的任何T的子类
 *PECS
  请记住PECS原则：生产者（Producer）使用extends，消费者（Consumer）使用super。
   生产者使用extends
   如果你需要一个列表提供T类型的元素（即你想从列表中读取T类型的元素），你需要把这个列表声明成<? extends T>，比如List<? extends Integer>，因此你不能往该列表中添加任何元素。
   消费者使用super
   如果需要一个列表使用T类型的元素（即你想把T类型的元素加入到列表中），你需要把这个列表声明成<? super T>，比如List<? super Integer>，因此你不能保证从中读取到的元素的类型。
   即是生产者，也是消费者
   如果一个列表即要生产，又要消费，你不能使用泛型通配符声明列表，比如List<Integer>。
 * @date 2018/6/15 15:39
 */
public class InsertArithmetic {

    public static <T> void insertSort(T[] ts,Comparator<? super T> comparator){
        for (int i = 0; i <ts.length ; i++) {
            T key = ts[i];
            int j = i -1;
           while (j>-1 && comparator.compare(key,ts[j])<0){
               ts[j+1]=ts[j];
               j--;
           }
           ts[j+1] = key;
        }
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{35,12,24,14,17,5};
        insertSort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (Integer i:nums
             ) {
            System.out.print(i+" ");
        }
    }
}
