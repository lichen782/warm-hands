package cn.lich.itv.one50;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 *      注意，你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * @author lich
 * @date 2024/2/21
 */
public class WordBreak {

    class Node {

        Node[] children = new Node[26];

        boolean isWord;

    }

    private Node root;

    private Set<Integer> visited;

    public boolean wordBreak(String s, List<String> wordDict) {
        root = buildNodeTree(wordDict);
        visited = new HashSet<>();
        return find(s.toCharArray(), 0);
    }

    private Node buildNodeTree(List<String> wordDict) {
        Node root = new Node();
        for (String word: wordDict) {
            add(root, word);
        }
        return root;
    }

    private boolean find(char[] charArray, int from) {
        if (from == charArray.length) {
            return true;
        }
        Node cur = root;
        while(from < charArray.length && cur.children[charArray[from] - 'a'] != null) {
            cur = cur.children[charArray[from] - 'a'];
            if (cur.isWord && !visited.contains(from)) {
                visited.add(from);
                if (find(charArray, from + 1)){
                    return true;
                }
            }
            from++;
        }
        return false;
    }

    private void add(Node root, String word) {
        for (char c: word.toCharArray()) {
            if (root.children[c - 'a'] == null) {
                root.children[c - 'a'] = new Node();
            }
            root = root.children[c - 'a'];
        }
        root.isWord = true;
    }

    public static void main(String[] args) {
        WordBreak w = new WordBreak();
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> wordDict = Arrays.asList("a","aa","aaa", "aaaa");
        System.out.println(w.wordBreak(s, wordDict));
    }
}
