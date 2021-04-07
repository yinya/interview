package com.interview.all.alg;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author yinya
 * @date 2021/4/7
 */
public class StackTest {

    /**
     * 判断给定的字符串仅有()[]{}是否满足一致性
     *
     */
    @Test
    public void test01(){
        String str = "()[]{}";
        boolean match = isMatch(str);
        System.out.println(match);

        str = "()[{}";
        match = isMatch(str);
        System.out.println(match);

        str = "(({}))";
        match = isMatch(str);
        System.out.println(match);
    }

    private boolean isMatch(String str) {
        if(null == str){
            return false;
        }
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<Character, Character>(){{
            put('}','{');
            put(']', '[');
            put(')', '(');
        }
        };

        for (int i = 0; i < chars.length; i++){
            if(map.containsKey(chars[i])){
                Character character = stack.pop();
                if(!map.get(chars[i]).equals(character)){
                    return false;
                }
            }else {
                stack.push(chars[i]);
            }
        }
        return stack.isEmpty()? true: false;
    }
}
