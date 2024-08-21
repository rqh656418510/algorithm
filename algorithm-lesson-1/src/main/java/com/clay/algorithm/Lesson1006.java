package com.clay.algorithm;

/**
 * LeetCode 第 26 道题 - 删除有序数组中的重复项，https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 */
public class Lesson1006 {

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
