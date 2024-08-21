package com.clay.algorithm.part001;

import java.util.Arrays;

/**
 * 插入排序
 */
public class Lesson0004 {

    public static void main(String[] args) {
        sort1();
        sort2();
    }

    /**
     * 效率低的写法（三次循环），但代码容易理解
     */
    public static void sort1() {
        int[] array = new int[] {7, 3, 8, 2, 1, 9, 4, 5};

        for (int i = 1; i < array.length; i++) {
            // 找到要重新排序的元素
            if (array[i] < array[i - 1]) {
                for (int j = 0; j < i; j++) {
                    // 找到元素要插入的位置
                    if (array[i] < array[j]) {
                        int tmp = array[i];
                        // 向后移动数组的元素
                        for (int k = i; k > j; k--) {
                            array[k] = array[k - 1];
                        }
                        array[j] = tmp;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(array));
    }

    /**
     * 效率高的写法（两次循环）
     */
    public static void sort2() {
        int[] array = new int[] {7, 3, 8, 2, 1, 9, 4, 5};

        for (int i = 1; i < array.length; i++) {
            // 当前要插入的元素
            int key = array[i];
            // 已排序的子数组的最后一个元素的索引
            int j = i - 1;

            // 将所有比当前元素大的元素向右移动一个位置，直到找到比当前元素小的元素或者已经到达子数组的开头
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            // 将当前元素插入到合适的位置
            array[j + 1] = key;
        }

        System.out.println(Arrays.toString(array));
    }

}
