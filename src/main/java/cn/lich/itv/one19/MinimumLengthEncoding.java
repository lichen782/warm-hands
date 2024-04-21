package cn.lich.itv.one19;

import java.util.*;

/**
 *单词数组 words 的 有效编码 由任意助记字符串 s 和下标数组 indices 组成，且满足：
 *
 * words.length == indices.length
 * 助记字符串 s 以 '#' 字符结尾
 * 对于每个下标 indices[i] ，s 的一个从 indices[i] 开始、到下一个 '#' 字符结束（但不包括 '#'）的 子字符串 恰好与 words[i] 相等
 * 给定一个单词数组 words ，返回成功对 words 进行编码的最小助记字符串 s 的长度 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：words = ["time", "me", "bell"]
 * 输出：10
 * 解释：一组有效编码为 s = "time#bell#" 和 indices = [0, 2, 5] 。
 * words[0] = "time" ，s 开始于 indices[0] = 0 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
 * words[1] = "me" ，s 开始于 indices[1] = 2 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
 * words[2] = "bell" ，s 开始于 indices[2] = 5 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
 * 示例 2：
 *
 * 输入：words = ["t"]
 * 输出：2
 * 解释：一组有效编码为 s = "t#" 和 indices = [0] 。
 *
 *
 * 提示：
 *
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 7
 * words[i] 仅由小写字母组成
 * @author lich
 * @date 2024/4/20
 */
public class MinimumLengthEncoding {

    class Node {

        Node[] next = new Node[26];

        boolean isWord;

        int childCount = 0;
    }

    private Node root;

    private int path;

    private List<Integer> len;

    public int minimumLengthEncoding(String[] words) {
        root = new Node();
        len = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            Node n = root;
            for (int j = words[i].length() - 1; j >= 0; j--) {
                int offset = words[i].charAt(j) - 'a';
                if (n.next[offset] == null) {
                    n.next[offset] = new Node();
                }
                n = n.next[offset];
            }
            n.isWord = true;
        }

        for (int i = 0; i < root.next.length; i++) {
            path = 0;
            if (root.next[i] != null) {
                dfs(root.next[i]);
            }
        }

        return len.stream().reduce(Integer::sum).get() + len.size();
    }

    public int minimumLengthEncoding2(String[] words) {
        root = new Node();
        len = new ArrayList<>();
        Map<Node, Integer> wordNode = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            Node n = root;
            for (int j = words[i].length() - 1; j >= 0; j--) {
                int offset = words[i].charAt(j) - 'a';
                if (n.next[offset] == null) {
                    n.childCount++;
                    n.next[offset] = new Node();
                }
                n = n.next[offset];
            }
            n.isWord = true;
            wordNode.put(n, i);
        }

        int ans = 0;
        for (Node wn: wordNode.keySet()) {
            if (wn.childCount == 0) {
                ans += words[wordNode.get(wn)].length() + 1;
            }
        }

        return ans;
    }

    private void dfs(Node root) {
        assert root != null;
        path++;

        if (root.isWord && Arrays.stream(root.next).allMatch(Objects::isNull)) {
            //dfs 最长word
            len.add(path);
        }

        for (int i = 0; i < root.next.length; i++) {
            if (root.next[i] != null) {
               dfs(root.next[i]);
            }
        }
        path--;
    }

    public static void main(String[] args) {
        MinimumLengthEncoding m = new MinimumLengthEncoding();
        String[] words = {"me","time","bell"};
        System.out.println(m.minimumLengthEncoding2(words));
    }
}
