package com.clay.algorithm.part001;

/**
 * 青蛙跳台阶
 *
 * <p> 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法
 */
public class Lesson0002 {

    public static void main(String[] args) {
        System.out.println(fn(3));
        System.out.println(loop(3));
    }

    /**
     * 递归的写法
     */
    public static int fn(int n) {
        if (n < 1) {
            throw new IllegalArgumentException(n + " is less than one");
        }
        if (n == 1 || n == 2) {
            return n;
        }
        return fn(n - 1) + fn(n - 2);
    }

    /**
     * 迭代（循环）的写法
     */
    public static int loop(int n) {
        if (n < 1) {
            throw new IllegalArgumentException(n + " is less than one");
        }
        if (n == 1 || n == 2) {
            return n;
        }

        int one = 2;    // 初始化为走到第二级台阶的走法
        int two = 1;    // 初始化为走到第一级台阶的走法
        int sum = 0;

        for (int i = 3; i <= n; i++) {
            sum = two + one;
            two = one;
            one = sum;
        }
        return sum;
    }

}
