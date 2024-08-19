package com.clay.algorithm.part001;

/**
 * 计算大整数的阶乘
 */
public class Lesson0003 {

    /**
     * 计算阶乘
     */
    public static String factorial(int n) {
        int[] ints = new int[1024];

        // 表示数值为 1
        ints[ints.length - 1] = 1;

        for (int i = 2; i <= n; i++) {
            ints = multiply(ints, i);
        }

        return convert(ints);
    }

    /**
     * 两数相乘，支持大整数运算
     *
     * @param ints 第一个数字，用数组表示每一位，如 [3, 6， 5]
     * @param num  第二个数字
     * @return 运算结果，使用数组表示每一位
     */
    private static int[] multiply(int[] ints, int num) {
        // 计算每一位相乘的结果
        for (int i = 0; i < ints.length; i++) {
            ints[i] *= num;
        }

        // 进位与留位
        for (int i = ints.length - 1; i > 0; i--) {
            ints[i - 1] += ints[i] / 10;
            ints[i] = ints[i] % 10;
        }
        return ints;
    }

    /**
     * 转换计算结果，忽略显示数组中最前面的零
     */
    private static String convert(int[] nums) {
        boolean ignoreZero = true;
        StringBuilder stringBuilder = new StringBuilder();
        for (int num : nums) {
            if (num == 0 && ignoreZero) {
                continue;
            } else if (num != 0 && ignoreZero) {
                ignoreZero = false;
            }
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int n = 50;
        String result = factorial(n);
        System.out.println(result);
    }

}
