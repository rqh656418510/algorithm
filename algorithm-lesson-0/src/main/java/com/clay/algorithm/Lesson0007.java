package com.clay.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 手写 LRU (最近最少使用) 缓存
 *
 * <p> 基于哈希表（HashMap） + 双向链表（DoubleLinkedList）实现 LRU 缓存
 */
public class Lesson0007 {

    private int cacheSize;
    private Map<Integer, Node<Integer, Integer>> map;
    private DoubleLinkedList<Integer, Integer> doubleLinkedList;

    public Lesson0007(int cacheSize) {
        this.cacheSize = cacheSize;
        this.map = new HashMap<>();
        this.doubleLinkedList = new DoubleLinkedList<>();
    }

    /**
     * PUT操作
     */
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        // 将最近使用的数据移动到链表的头部
        Node<Integer, Integer> node = map.get(key);
        doubleLinkedList.remove(node);
        doubleLinkedList.addHead(node);
        return node.value;
    }

    /**
     * GET操作
     */
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // 更新节点的值，并将最近使用的数据移动到链表的头部
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            doubleLinkedList.remove(node);
            doubleLinkedList.addHead(node);
        } else {
            // 位置满了，删除数据
            if (map.size() == this.cacheSize) {
                Node<Integer, Integer> lastNode = doubleLinkedList.getLast();
                doubleLinkedList.remove(lastNode);
                map.remove(lastNode.key);
            }
            // 插入新的节点
            Node<Integer, Integer> newNode = new Node<>(key, value);
            doubleLinkedList.addHead(newNode);
            map.put(key, newNode);
        }
    }

    /**
     * Node节点
     */
    class Node<K, V> {

        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        public Node() {
            this.key = null;
            this.value = null;
            this.prev = null;
            this.next = null;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    /**
     * 虚拟的双向链表
     */
    class DoubleLinkedList<K, V> {

        Node<K, V> head;    // 头节点
        Node<K, V> tail;    // 尾节点

        public DoubleLinkedList() {
            this.head = new Node<>();
            this.tail = new Node<>();
            // 初始状态是头尾相连
            this.head.next = tail;
            this.tail.prev = head;
        }

        /**
         * 添加到头部
         * <p> 将最近使用的数据移动到链表的头部
         */
        public void addHead(Node<K, V> node) {
            node.prev = this.head;
            node.next = this.head.next;
            this.head.next.prev = node;
            this.head.next = node;
        }

        /**
         * 删除节点
         */
        public void remove(Node<K, V> node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            // GC
            node.prev = null;
            node.next = null;
        }

        /**
         * 获取最后一个节点
         */
        public Node<K, V> getLast() {
            return this.tail.prev;
        }
    }

    public static void main(String[] args) {
        Lesson0007 lruCache = new Lesson0007(3);

        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        System.out.println(lruCache.map.keySet());

        lruCache.put(4, 4);
        System.out.println(lruCache.map.keySet());

        lruCache.put(3, 3);
        System.out.println(lruCache.map.keySet());
        lruCache.put(3, 3);
        System.out.println(lruCache.map.keySet());
        lruCache.put(3, 3);
        System.out.println(lruCache.map.keySet());
        lruCache.put(5, 5);
        System.out.println(lruCache.map.keySet());
    }

}
