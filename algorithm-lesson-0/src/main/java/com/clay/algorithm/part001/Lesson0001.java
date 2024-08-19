package com.clay.algorithm.part001;

/**
 * 二分查找
 */
public class Lesson0001 {

    /**
     * 二分查找
     *
     * @param array  有序数组
     * @param target 目标值
     * @return 目标值的下标，查找不到则返回 -1
     */
    public static int binarySearch(int[] array, int target) {
        int left = 0;  // 左边位置
        int middle = 0;  // 中间位置
        int right = array.length - 1;  // 右边位置

        while (left <= right) {
            middle = (left + right) / 2;
            if (array[middle] == target) {
                // 找到目标值
                return middle;
            } else if (array[middle] < target) {
                // 目标值在数组的右侧
                left = middle + 1;
            } else {
                // 目标值在数组的左侧
                right = middle - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // 数据集合必须是有序的
        int[] array = {2, 4, 7, 8, 10, 12, 16, 19, 20};

        // 目标值
        int target = 12;
        // 目标值的位置
        int index = binarySearch(array, target);

        // 打印结果
        if (index == -1) {
            System.out.println("Not found number " + target);
        } else {
            System.out.println("Found number " + target + ", Position is " + index);
        }
    }

}
