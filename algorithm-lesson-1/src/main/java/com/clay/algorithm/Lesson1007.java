package com.clay.algorithm;

/**
 * LeetCode 第 283 道题 - 移动零，https://leetcode.cn/problems/move-zeroes/
 *
 * <p> 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p> 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class Lesson1007 {

    public static int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] array = new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int length = removeDuplicates(array);
        System.out.println(length);
    }

}
