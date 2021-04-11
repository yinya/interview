package com.interview.all.alg;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yinya
 * @date 2021/4/11
 */
public class FirstKTest {
    /**
     * 一列数字串，找到第k小的数
     *
     * 利用小顶堆。存储K个最小的值。数字流中的值大于max(heap) 将最大取出，并放入新值。否则跳过。
     *
     * 堆:
     *   max/min         O(1)
     *   delete/insert   lg(n)
     */
    @Test
    public void test(){
        Integer[] list = new Integer[]{1,2,4,8,16,32,64,128};
        Integer value = getMinKValue(list, 5);
        System.out.println(value);
    }

    public Integer getMinKValue(Integer[] list, int n){
        if(list.length < n || n <=0){
            throw new RuntimeException("参数异常");
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(n, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for(int i = 0; i < list.length; i++){
            if(priorityQueue.size() < n){
                priorityQueue.add(list[i]);
            }else {
                if(list[i] < priorityQueue.peek()){
                    priorityQueue.poll();
                    priorityQueue.add(list[i]);
                }
            }
        }
        return priorityQueue.peek();
    }
}
