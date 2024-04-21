package cn.lich.itv.one50;

import java.util.*;

/**
 *
 * 字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
 *
 * 每一对相邻的单词只差一个字母。
 *  对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
 * sk == endWord
 * 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。
 *
 *
 * 示例 1：
 *
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出：5
 * 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
 * 示例 2：
 *
 * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * 输出：0
 * 解释：endWord "cog" 不在字典中，所以无法进行转换。
 *
 * @author lich
 * @date 2024/1/30
 */
public class LadderLength {

    class Node {
        String val;
        List<Node> next;

        Node(String val) {
            this.val = val;
            this.next = new ArrayList<>();
        }
    }

    private Map<String, Node> nodeMap = new HashMap<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 2;
        }
        if (!wordList.contains(endWord)) {
            return 0;
        }
        buildGraph(beginWord, wordList);

        return bfs(beginWord, endWord);
    }

    private int bfs(String beginWord, String endWord) {
        LinkedList<Node> queue = new LinkedList<>();
        Node st = nodeMap.get(beginWord);
        queue.add(st);
        Map<String, Integer> visited = new HashMap<>();
        visited.put(beginWord, 1);

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            int step = visited.get(n.val) + 1;
            for (Node nxt: n.next) {
                if (nxt.val.equals(endWord)) {
                    return step;
                }
                if (visited.containsKey(nxt.val)) {
                    continue;
                }
                visited.put(nxt.val, step);
                queue.add(nxt);
            }
        }
        return 0;
    }

    private void buildGraph(String beginWord, List<String> wordList) {
        nodeMap.clear();
        for (int i = 0; i < wordList.size(); i++) {
            nodeMap.put(wordList.get(i), new Node(wordList.get(i)));
        }
        nodeMap.put(beginWord, new Node(beginWord));
        for (String s1 : nodeMap.keySet()) {
            for (String s2 : nodeMap.keySet()) {
                if (!s1.equals(s2) && link(s1, s2)) {
                    nodeMap.get(s1).next.add(nodeMap.get(s2));
                }
            }
        }
    }

    private boolean link(String start, String end) {
        if (start.length() != end.length()) {
            return false;
        }
        int diff = 0;
        for (int i = 0; i < start.length(); i++) {
            diff += (start.charAt(i) == end.charAt(i) ? 0 : 1);
            if (diff > 1) {
                return false;
            }
        }
        return diff == 1;
    }

    public static void main(String[] args) {
        LadderLength m = new LadderLength();
        String[][][] testcases = {
                {{"hit", "cog"}, {"hot","dot","dog","lot","log","cog"}},
                {{"hit", "cog"}, {"hot","dot","dog","lot","log"}},
        };
        for (String[][] tc: testcases) {
            List<String> wordList = new ArrayList<>(tc[1].length);
            for (String w: tc[1]) {
                wordList.add(w);
            }
            System.out.println(m.ladderLength(tc[0][0], tc[0][1], wordList));
        }
    }
}
