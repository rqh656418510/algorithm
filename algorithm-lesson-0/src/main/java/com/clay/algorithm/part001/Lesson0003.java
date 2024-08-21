package com.clay.algorithm.part001;

/**
 * 给定一个数 m，求大于该数的最小 2 的 n 次幂，返回 n
 */
public class Lesson0003 {

    public static int findNumber(int m) {
        int n = 0;
        while ((1 << n) <= m) {
            n++;
        }
        return n;
    }

    public static void main(String[] args) {
        int m = 20;
        int n = findNumber(m);
        System.out.println("n = " + n);
    }

}
