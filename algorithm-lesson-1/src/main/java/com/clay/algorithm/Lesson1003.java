package com.clay.algorithm;

import java.util.stream.Stream;

/**
 * LeetCode 第 344 道题 - 反转字符串，https://leetcode.cn/problems/reverse-string/
 *
 * <p> 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * <p> 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O (1) 的额外空间解决这一问题。
 */
public class Lesson1003 {

    public static void reverse(char[] s) {
        for (int left = 0; left < s.length; left++) {
            int right = s.length - left - 1;
            if (left < right) {
                char tmp = s[left];
                s[left] = s[right];
                s[right] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        char[] str = new char[] {'h', 'e', 'l', 'l', 'o'};
        reverse(str);
        Stream.of(str).forEach(System.out::println);
    }

}


