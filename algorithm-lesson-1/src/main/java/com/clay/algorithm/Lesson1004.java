package com.clay.algorithm;

import java.util.Arrays;

/**
 * LeetCode 第 167 道题 - 两数之和 II - 输入有序数组，https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/
 *
 * <p> 给你一个下标从 1 开始的整数数组 numbers ，该数组已按非递减顺序排列，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 * <p> 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * <p> 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * <p> 你所设计的解决方案必须只使用常量级的额外空间。
 */
public class Lesson1004 {

    public static int[] twoSum(int[] numbers, int target) {
        // 左指针
        int left = 0;
        // 右指针
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] {left + 1, right + 1};
            } else if (sum < target) {
                // 让 sum 大一点，左指针右移
                left++;
            } else {
                // 让 sum 小一点，右指针左移
                right--;
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] numbers = new int[] {2, 7, 11, 15};
        int[] result = twoSum(numbers, 9);
        Arrays.stream(result).forEach(item -> {
            System.out.print(item + " ");
        });
    }

}
