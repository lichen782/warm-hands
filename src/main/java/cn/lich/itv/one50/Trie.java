package cn.lich.itv.one50;

/**
 * @author lich
 * @date 2024/1/31
 */
public class Trie {

    class Node {
        boolean hasTerminate;
        Node[] children;

        Node() {
            this.children = new Node[26];
        }
    }

    private Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new Node();
            }
            cur = cur.children[index];
        }
        cur.hasTerminate = true;
    }

    public boolean search(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                return false;
            }
            cur = cur.children[index];
        }
        return cur.hasTerminate;
    }

    public boolean startsWith(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (cur.children[index] == null) {
                return false;
            }
            cur = cur.children[index];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println("search apple: " + trie.search("apple"));   // 返回 True
        System.out.println("search app : " + trie.search("app"));   // 返回 False
        System.out.println("startsWith app: " + trie.startsWith("app")); // 返回 True
        trie.insert("app");

        System.out.println("search app: " + trie.search("app")); // 返回 True
    }
}
