package cn.lich.itv.one19;

import java.util.HashMap;
import java.util.Map;

/**
 * 运用所掌握的数据结构，设计和实现一个  LRU (Least Recently Used，最近最少使用) 缓存机制 。
 *
 * 实现 LRUCache 类：
 *
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * @author lich
 * @date 2024/3/29
 */
public class LRUCache {

    class Item {
        int key;

        int val;

        Item next;

        Item pre;
    }

    private int capacity;

    private Item head;

    private Item tail;

    private Map<Integer, Item> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Item();
        this.tail = new Item();
        moveToFirst(this.tail);
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Item target = getOrCreate(key);
            return target.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Item item = getOrCreate(key);
        item.val = value;
    }

    private Item getOrCreate(int key) {
        Item target;
        if (map.containsKey(key)) {
            target = map.get(key);
        } else {
            target = new Item();
            target.key = key;
            if (map.size() == capacity) {
                //remove from tail
                if (tail.pre != head) {
                    Item lastOne = tail.pre;
                    remove(lastOne);
                    map.remove(lastOne.key);
                }
            }
            map.put(key, target);
        }
        moveToFirst(target);
        return target;
    }

    private void moveToFirst(Item target) {
        if (target.pre != null) {
            target.pre.next = target.next;
        }
        if (target.next != null) {
            target.next.pre = target.pre;
        }

        if (head.next != null) {
            head.next.pre = target;
        }
        target.next = head.next;
        head.next = target;
        target.pre = head;
    }

    private void remove(Item target) {
        if (target.pre != null) {
            target.pre.next = target.next;
        }
        if (target.next != null) {
            target.next.pre = target.pre;
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));    // 返回 3
        System.out.println(lRUCache.get(4));    // 返回 4

    }
}
