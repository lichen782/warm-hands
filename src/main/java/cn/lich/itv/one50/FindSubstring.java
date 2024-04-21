package cn.lich.itv.one50;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
 * <p>
 * s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
 * <p>
 * 例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
 * 返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：因为 words.length == 2 同时 words[i].length == 3，连接的子字符串的长度必须为 6。
 * 子串 "barfoo" 开始位置是 0。它是 words 中以 ["bar","foo"] 顺序排列的连接。
 * 子串 "foobar" 开始位置是 9。它是 words 中以 ["foo","bar"] 顺序排列的连接。
 * 输出顺序无关紧要。返回 [9,0] 也是可以的。
 * 示例 2：
 * <p>
 * 输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * 输出：[]
 * 解释：因为 words.length == 4 并且 words[i].length == 4，所以串联子串的长度必须为 16。
 * s 中没有子串长度为 16 并且等于 words 的任何顺序排列的连接。
 * 所以我们返回一个空数组。
 * 示例 3：
 * <p>
 * 输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * 输出：[6,9,12]
 * 解释：因为 words.length == 3 并且 words[i].length == 3，所以串联子串的长度必须为 9。
 * 子串 "foobarthe" 开始位置是 6。它是 words 中以 ["foo","bar","the"] 顺序排列的连接。
 * 子串 "barthefoo" 开始位置是 9。它是 words 中以 ["bar","the","foo"] 顺序排列的连接。
 * 子串 "thefoobar" 开始位置是 12。它是 words 中以 ["the","foo","bar"] 顺序排列的连接。
 *
 * @author lich
 * @date 2024/3/4
 */
public class FindSubstring {

    public List<Integer> findSubstring(String s, String[] words) {
        if (words.length == 0) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();

        int n = words[0].length();
        int l = n * words.length;

        Map<String, Integer> count = count(words);
        Map<String, Integer> ct = new HashMap<>(count);
        int i = 0;
        int st = i;

        while (i <= s.length() - l) {

            while (!ct.isEmpty()) {
                //System.out.println("check: " +  s.substring(i, st + n));
                String w = s.substring(st, st + n);
                if (removeWord(ct, w)) {
                    st += n;
                    //System.out.println("step ahead: " + s.substring(st));
                } else {
                    // [st, st+n)
                    //System.out.println("break at: " + s.substring(st));
                    break;
                }
            }

            if (ct.isEmpty()) {
                ans.add(i);
            }
            i++;
            st = i;
            ct = new HashMap<>(count);

        }

        return ans;
    }

    private boolean removeWord(Map<String, Integer> counter, String w) {
        if (counter.containsKey(w)) {
            int c = counter.get(w);
            c -= 1;
            if (c == 0) {
                counter.remove(w);
            } else {
                counter.put(w, c);
            }
            return true;
        }
        return false;
    }

    private Map<String, Integer> addWord(Map<String, Integer> counter, String w) {
        if (!counter.containsKey(w)) {
            counter.put(w, 0);
        }
        counter.put(w, counter.get(w) + 1);
        return counter;
    }

    private Map<String, Integer> count(String[] words) {
        Map<String, Integer> counter = new HashMap<>();
        for (String w : words) {
            addWord(counter, w);
        }
        return counter;
    }

    public static void main(String[] args) {
        FindSubstring f = new FindSubstring();
        String s = "barfoofoobarthefoobarman";
        String[] word = {"bar","foo","the"};
        List<Integer> l = f.findSubstring(s, word);
        for (Integer i: l) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
