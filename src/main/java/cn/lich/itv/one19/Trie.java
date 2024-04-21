package cn.lich.itv.one19;

/**
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 *
 * 请你实现 Trie 类：
 *
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 *
 *
 * 示例：
 *
 * 输入
 * inputs = ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * inputs = [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * 输出
 * [null, null, true, false, true, null, true]
 *
 * 解释
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 True
 * trie.search("app");     // 返回 False
 * trie.startsWith("app"); // 返回 True
 * trie.insert("app");
 * trie.search("app");     // 返回 True
 *
 * @author lich
 *
 * @date 2024/4/20
 */
public class Trie {

    class Node {

        Node[] next = new Node[26];

        boolean isWord;
    }

    private Node root;

    /** Initialize your data structure here. */
    public Trie() {
       root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word.length() == 0) {
            return;
        }
        Node n = root;
        for (int i = 0; i < word.length(); i++) {
            int offset = word.charAt(i) - 'a';
            if (n.next[offset] == null) {
                n.next[offset] = new Node();
            }
            n = n.next[offset];
        }
        n.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word.length() == 0) {
            return false;
        }
        Node n = root;
        for (int i = 0; i < word.length(); i++) {
            int offset = word.charAt(i) - 'a';
            if (n.next[offset] == null) {
                return false;
            }
            n = n.next[offset];
        }
        return n.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node n = root;
        for (int i = 0; i < prefix.length(); i++) {
            int offset = prefix.charAt(i) - 'a';
            if (n.next[offset] == null) {
                return false;
            }
            n = n.next[offset];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // 返回 True
        System.out.println(trie.search("app"));     // 返回 False
        System.out.println(trie.startsWith("app")); // 返回 True
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 True
    }
}
