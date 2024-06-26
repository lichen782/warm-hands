package cn.lich.itv.one19;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长连续子字符串 的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子字符串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子字符串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 * @author lich
 * @date 2024/3/20
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int maxLen = 0;

        for (int i = 0, j = 0; j < s.length(); j++) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                maxLen = Math.max(maxLen, j - i + 1);
            } else {
                while (i < j && set.contains(s.charAt(j))) {
                    set.remove(s.charAt(i));
                    i++;
                }
                set.add(s.charAt(j));
            }
        }

        return maxLen;

    }

    public static void main(String[] args) {
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        String s = "pwwkew";
        System.out.println(l.lengthOfLongestSubstring(s));
    }
}
