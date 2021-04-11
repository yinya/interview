package com.interview.all.alg;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author yinya
 * @date 2021/4/11
 */
public class QueueTest {


    /**
     * 利用堆栈实现队列
     *
     */
    @Test
    public void test(){
        Integer[] originList = new Integer[]{1,2,4,8,16};
        StackQueue stackQueue = new StackQueue();
        for(int i=0; i < originList.length; i++){
            stackQueue.add(originList[i]);
        }
        while (!stackQueue.isEmpty()){
            System.out.println(stackQueue.pull());
        }
    }

    public class StackQueue{
        private Stack<Integer> inStack = new Stack<>();
        private Stack<Integer> outStack = new Stack<>();

        public synchronized boolean add(Integer integer){
            return inStack.add(integer);
        }

        public synchronized Integer pull(){
            if(!outStack.isEmpty()){
                return outStack.pop();
            }
            resort();
            return outStack.pop();
        }
        public Integer peek(){
            if(!outStack.isEmpty()){
                return outStack.peek();
            }
            resort();
            return inStack.peek();
        }

        public boolean isEmpty(){
            if(inStack.isEmpty() && outStack.isEmpty()){
                return true;
            }
            return false;
        }

        private synchronized void resort() {
            if(outStack.isEmpty()){
                while (!inStack.isEmpty()){
                    outStack.push(inStack.pop());
                }
            }
        }
    }
}
