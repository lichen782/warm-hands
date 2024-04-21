package cn.lich.itv.one19;


import java.util.*;

/**
 * 设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于已构建的神奇字典中。
 * <p>
 * 实现 MagicDictionary 类：
 * <p>
 * MagicDictionary() 初始化对象
 * void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字符串互不相同
 * bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，使得所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入
 * inputs = ["MagicDictionary", "buildDict", "search", "search", "search", "search"]
 * inputs = [[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
 * 输出
 * [null, null, false, true, false, false]
 * <p>
 * 解释
 * MagicDictionary magicDictionary = new MagicDictionary();
 * magicDictionary.buildDict(["hello", "leetcode"]);
 * magicDictionary.search("hello"); // 返回 False
 * magicDictionary.search("hhllo"); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
 * magicDictionary.search("hell"); // 返回 False
 * magicDictionary.search("leetcoded"); // 返回 False
 *
 * @author lich
 * @date 2024/4/20
 */
public class MagicDictionary {

    private Map<Integer, Map<String, Set<String>>> wordByLen;

    /**
     * Initialize your data structure here.
     */
    public MagicDictionary() {
        wordByLen = new HashMap<>();
    }

    public void buildDict(String[] dictionary) {
        for (int i = 0; i < dictionary.length; i++) {
            Map<String, Set<String>> l =
                    wordByLen.getOrDefault(dictionary[i].length(), new HashMap<>());
            char[] arr = dictionary[i].toCharArray();
            for (int j = 0; j < dictionary[i].length(); j++) {
                char o = arr[j];
                arr[j] = '*';
                String p = new String(arr);
                Set<String> s = l.getOrDefault(p, new HashSet<>());
                s.add(dictionary[i]);
                l.put(p, s);
                arr[j] = o;
            }
            wordByLen.put(dictionary[i].length(), l);
        }
    }

    public boolean search(String searchWord) {
        if (!wordByLen.containsKey(searchWord.length())) {
            return false;
        }

        Map<String, Set<String>> m = wordByLen.get(searchWord.length());

        char[] arr = searchWord.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char o = arr[i];
            arr[i] = '*';
            String p = new String(arr);
            if (m.containsKey(p)) {
                Set<String> wid = m.get(p);
                if (!wid.contains(searchWord) || (wid.size() > 1)) {
                    return true;
                }
            }
            arr[i] = o;
        }

        return false;
    }


    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        String[] words = {"hello", "hallo", "leetcode"};
        magicDictionary.buildDict(words);
        System.out.println(magicDictionary.search("hello")); // 返回 False
        System.out.println(magicDictionary.search("hhllo")); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
        System.out.println(magicDictionary.search("hell")); // 返回 False
        System.out.println(magicDictionary.search("leetcoded")); // 返回 False
    }
}
