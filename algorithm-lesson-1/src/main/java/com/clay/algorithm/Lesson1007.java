package com.clay.algorithm;

import java.util.Arrays;

/**
 * LeetCode 第 283 道题 - 移动零，https://leetcode.cn/problems/move-zeroes/
 *
 * <p> 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p> 请注意，必须在不复制数组的情况下原地对数组进行操作。
 */
public class Lesson1007 {

    public static void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                int tmp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = tmp;
                slow++;
            }
            fast++;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {0, 1, 0, 3, 12};
        moveZeroes(array);
        Arrays.stream(array).forEach(item -> System.out.print(item + " "));
    }

}
