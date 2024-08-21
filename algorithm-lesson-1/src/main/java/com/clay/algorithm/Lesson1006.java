package com.clay.algorithm;

/**
 * LeetCode 第 26 道题 - 删除有序数组中的重复项，https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 *
 * <p> 给你一个非严格递增排列的数组 nums，请你原地删除重复出现的元素，使每个元素只出现一次，返回删除后数组的新长度。元素的相对顺序应该保持一致。然后返回 nums 中唯一元素的个数。
 * <p> 考虑 nums 的唯一元素的数量为 k，你需要做以下事情确保你的题解可以被通过：
 * <p> 更改数组 nums，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
 * <p> 返回 k 。
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
