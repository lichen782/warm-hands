package cn.lich.itv.one50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 *
 * 实现词典类 WordDictionary ：
 *
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 *
 *
 * 示例：
 *
 * 输入：
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * 输出：
 * [null,null,null,null,false,true,true,true]
 *
 * 解释：
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // 返回 False
 * wordDictionary.search("bad"); // 返回 True
 * wordDictionary.search(".ad"); // 返回 True
 * wordDictionary.search("b.."); // 返回 True
 * @author lich
 * @date 2024/1/31
 */
public class WordDictionary {

    class Node {

        boolean hasTerminate;

        Node[] children;



        public Node() {
            children = new Node[26];
        }
    }

    private Node root;

    public WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {
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
        List<Node> candidates = new ArrayList<>();
        candidates.add(root);
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            candidates = fromRootCandidate(candidates, c);
            if (candidates.size() == 0) {
                return false;
            }
        }
        return candidates.stream().filter(n -> n.hasTerminate).findFirst().isPresent();
    }

    private List<Node> fromRootCandidate(List<Node> candidate, char c) {
        List<Node> newCandidate = new ArrayList<>();
        for (Node n: candidate) {
            if (c == '.') {
                newCandidate.addAll(Arrays.stream(n.children).filter(Objects::nonNull).collect(Collectors.toList()));
            } else {
                int index = c - 'a';
                if (n.children[index] != null) {
                    newCandidate.add(n.children[index]);
                }
            }
        }
        return newCandidate;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        String[] cases = {
                "pad", "bad", ".ad", "b..", "m...", "m.", "m..", "m.d"
        };
        for (String w: cases) {
           System.out.println(w + ": " + wordDictionary.search(w));
        }

    }

}
