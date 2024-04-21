package cn.lich.itv.one19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 变位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 变位词 指字母相同，但排列不同的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的变位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的变位词。
 *  示例 2：
 *
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的变位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的变位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的变位词。
 * @author lich
 * @date 2024/3/20
 */
public class FindAnagrams {

    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }

        List<Integer> ans = new ArrayList<>();

        int[] cntp = new int[26];
        int[] cnts = new int[26];
        for (int i = 0; i < p.length(); i++) {
            cntp[p.charAt(i) - 'a']++;
            cnts[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(cntp, cnts)) {
            ans.add(0);
        }

        for (int i = p.length(); i < s.length(); i++) {
            cnts[s.charAt(i) - 'a']++;
            cnts[s.charAt(i - p.length()) - 'a']--;

            if (Arrays.equals(cnts, cntp)) {
                ans.add(i - p.length() + 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        FindAnagrams f = new FindAnagrams();
        String s = "abab";
        String p = "ab";
        List<Integer> l = f.findAnagrams(s, p);
        for (int i = 0; i < l.size(); i++) {
            System.out.print(l.get(i) + ", ");
        }
    }


}
