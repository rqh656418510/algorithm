package com.clay.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 第 1 道题 - 两数之和，https://leetcode.cn/problems/two-sum/
 *
 * <p> 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回它们的数组下标。你可以假设每种输入只会对应一个答案，但是，数组中同一个元素不能使用两遍。
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Lesson0001 {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (numMap.containsKey(diff)) {
                return new int[] {numMap.get(diff), i};
            }
            // key-数组元素的值，value-数组的下标
            numMap.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int target = 9;
        int[] nums = {2, 7, 11, 15};
        int[] result = twoSum(nums, target);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }

}
