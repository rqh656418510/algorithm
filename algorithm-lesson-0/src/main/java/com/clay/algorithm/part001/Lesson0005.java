package com.clay.algorithm.part001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 去除 List 中的重复元素
 *
 * <p> 将 List 集合中的重复元素去除掉，要求至少给出三种实现方案
 */
public class Lesson0005 {

    /**
     * 第一种方案：遍历 List，判断 newList 是否存在某个元素，如果不存在，则添加到 newList 里面
     */
    public static void test01() {
        List<Integer> initList = new ArrayList<>(Arrays.asList(60, 30, 30, 55, 12, 23, 23, 75, 42, 42, 42, 88));
        List<Integer> newList = new ArrayList<>();
        initList.forEach(item -> {
            if (!newList.contains(item)) {
                newList.add(item);
            }
        });
        newList.forEach(item -> System.out.print(item + " "));
    }

    /**
     * 第二种方案：使用 LinkedHashSet 去重
     */
    public static void test02() {
        List<Integer> initList = new ArrayList<>(Arrays.asList(60, 30, 30, 55, 12, 23, 23, 75, 42, 42, 42, 88));
        Set<Integer> newSet = new LinkedHashSet<>(initList);
        newSet.forEach(item -> System.out.print(item + " "));
    }

    /**
     * 第三种方案：使用 Stream 流式计算去重
     */
    public static void test03() {
        List<Integer> initList = new ArrayList<>(Arrays.asList(60, 30, 30, 55, 12, 23, 23, 75, 42, 42, 42, 88));
        List<Integer> newList = initList.stream().distinct().collect(Collectors.toList());
        newList.forEach(item -> System.out.print(item + " "));
    }

    /**
     * 第四种方案：使用循环坐标去重，类似双指针，按照值找到下标，如果两次找到的下标不同，则表示元素有重复，需要删除元素
     */
    public static void test04() {
        List<Integer> list = new ArrayList<>(Arrays.asList(60, 30, 30, 55, 12, 23, 23, 75, 42, 42, 42, 88));
        List<Integer> srcList = new ArrayList<>(list);
        List<Integer> newList = new ArrayList<>(list);

        for (Integer item : srcList) {
            if (newList.indexOf(item) != newList.lastIndexOf(item)) {
                newList.remove(newList.lastIndexOf(item));
            }
        }

        newList.forEach(item -> System.out.print(item + " "));
    }

    /**
     * 第五种方案：双 For 循环对比，通过下标获得值，外层循环和内层循环对比，值相同则删除元素
     */
    public static void test05() {
        List<Integer> list = new ArrayList<>(Arrays.asList(60, 30, 30, 55, 12, 23, 23, 75, 42, 42, 42, 88));
        List<Integer> newList = new ArrayList<>(list);

        for (int i = 0; i < newList.size(); i++) {
            for (int j = newList.size() - 1; j > i; j--) {
                if (newList.get(j).equals(newList.get(i))) {
                    newList.remove(j);
                }
            }
        }

        newList.forEach(item -> System.out.print(item + " "));
    }

}
