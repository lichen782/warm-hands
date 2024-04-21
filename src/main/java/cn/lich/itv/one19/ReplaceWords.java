package cn.lich.itv.one19;

import cn.lich.itv.utils.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 在英语中，有一个叫做 词根(root) 的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 * <p>
 * 现在，给定一个由许多词根组成的词典和一个句子，需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 * <p>
 * 需要输出替换之后的句子。
 *
 * @author lich
 * @date 2024/4/20
 */
public class ReplaceWords {

    class Node {

        Node[] next = new Node[26];

        boolean isWord;
    }

    private Node root;


    public String replaceWords(List<String> dictionary, String sentence) {
        root = new Node();
        for (String w : dictionary) {
            Node n = root;
            for (int i = 0; i < w.length(); i++) {
                int offset = w.charAt(i) - 'a';
                if (n.next[offset] == null) {
                    n.next[offset] = new Node();
                }
                n = n.next[offset];
            }
            n.isWord = true;
        }

        String[] ws = sentence.split("\\s");

        for (int i = 0; i < ws.length; i++) {
            String w = ws[i];
            Node n = root;
            int end = w.length() - 1;
            for (int j = 0; j < w.length(); j++) {
                int offset = w.charAt(j) - 'a';
                if (n.next[offset] == null) {
                    break;
                } else if (n.next[offset].isWord) {
                    end = j;
                    break;
                }
                n = n.next[offset];
            }
            ws[i] = ws[i].substring(0, end + 1);
        }

        return String.join(" ", ws);
    }

    public static void main(String[] args) {
        ReplaceWords rw = new ReplaceWords();
        String[][] cases = {
                // dict , sentence, expected
                {"cat","bat","rat"}, {"the cattle was rattled by the battery"}, {"the cat was rat by the bat"},
                {"a","b","c"}, {"aadsfasf absbs bbab cadsfafs"}, {"a a b c"},
                {"a", "aa", "aaa", "aaaa"}, {"a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"}, {"a a a a a a a a bbb baba a"},
                {"catt","cat","bat","rat"}, {"the cattle was rattled by the battery"}, {"the cat was rat by the bat"},
                {"ac","ab"}, {"it is abnormal that this solution is accepted"}, {"it is ab that this solution is ac"}
        };

        for (int i = 0; i < cases.length - 3; i += 3) {
            String[] dict = cases[i];
            List<String> d = Arrays.stream(dict).collect(Collectors.toList());
            String sentence  = cases[i + 1][0];
            String expected  = cases[i + 2][0];
            String output = rw.replaceWords(d, sentence);
            System.out.println("expected: " + expected + ", output: " + output);
        }
    }

}
