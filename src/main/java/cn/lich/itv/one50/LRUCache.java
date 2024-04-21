package cn.lich.itv.one50;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lich
 * @date 2024/1/20
 */
public class LRUCache {

    class DoubleListNode {

        private int key;

        private int val;
        private DoubleListNode pre;
        private DoubleListNode next;
    }

    private Map<Integer, DoubleListNode> map;

    private DoubleListNode head;

    private DoubleListNode tail;

    private int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new DoubleListNode();
        tail = new DoubleListNode();
        moveToHead(tail);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DoubleListNode node = map.get(key);
            moveToHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DoubleListNode node = map.get(key);
            node.val = value;
            moveToHead(node);
        } else {
            // 新增 key
            if (map.size() >= capacity) {
                DoubleListNode old = tail.pre;
                if (old != head) {
                    deleteNode(old);
                    map.remove(old.key);
                }
            }

            DoubleListNode node = new DoubleListNode();
            node.key = key;
            node.val = value;
            moveToHead(node);
            map.put(key, node);
        }
    }

    private void deleteNode(DoubleListNode node) {
        if (node.pre != null) {
            node.pre.next = node.next;
        }
        if (node.next != null) {
            node.next.pre = node.pre;
        }
    }

    private void moveToHead(DoubleListNode node) {

        deleteNode(node);

        // move to head
        node.pre = head;
        node.next = head.next;
        if (head.next != null) {
            head.next.pre = node;
        }
        head.next = node;
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        int val = lRUCache.get(1);    // 返回 1
        System.out.println(val);

        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        val = lRUCache.get(2);    // 返回 -1 (未找到)
        System.out.println(val);

        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}

        val = lRUCache.get(1);    // 返回 -1 (未找到)
        System.out.println(val);

        val = lRUCache.get(3);    // 返回 3
        System.out.println(val);

        val = lRUCache.get(4);    // 返回 4
        System.out.println(val);
    }
}
