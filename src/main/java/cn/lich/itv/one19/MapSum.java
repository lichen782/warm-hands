package cn.lich.itv.one19;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现一个 MapSum 类，支持两个方法，insert 和 sum：
 *
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 *
 *
 * 示例：
 *
 * 输入：
 * inputs = ["MapSum", "insert", "sum", "insert", "sum"]
 * inputs = [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
 * 输出：
 * [null, null, 3, null, 5]
 *
 * 解释：
 * MapSum mapSum = new MapSum();
 * mapSum.insert("apple", 3);
 * mapSum.sum("ap");           // return 3 (apple = 3)
 * mapSum.insert("app", 2);
 * mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
 *
 *
 * 提示：
 *
 * 1 <= key.length, prefix.length <= 50
 * key 和 prefix 仅由小写英文字母组成
 * 1 <= val <= 1000
 * 最多调用 50 次 insert 和 sum
 *
 * @author lich
 * @date 2024/4/21
 */
public class MapSum {

    class Node {

        Node[] next = new Node[26];

        int sum = 0;

    }

    private Map<String, Integer> kv;

    private Node root;

    /** Initialize your data structure here. */
    public MapSum() {
        root = new Node();
        kv = new HashMap<>();
    }

    public void insert(String key, int val) {
        int oldV = kv.getOrDefault(key, 0);
        int diff = val - oldV;

        Node n = root;
        for (int i = 0; i < key.length(); i++) {
            int offset = key.charAt(i) - 'a';
            if (n.next[offset] == null) {
                n.next[offset] = new Node();
            }
            n.next[offset].sum += diff;
            n = n.next[offset];
        }

        kv.put(key, val);

    }

    public int sum(String prefix) {
        Node n = root;
        for (int i = 0; i < prefix.length(); i++) {
            int offset = prefix.charAt(i) - 'a';
            if (n.next[offset] == null) {
                return 0;
            }
            n = n.next[offset];
        }
        return n.sum;
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));           // return 3 (apple = 3)
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));           // return 5 (apple + app = 3 + 2 = 5)
    }
}
