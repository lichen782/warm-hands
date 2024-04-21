package cn.lich.itv.one50;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @author lich
 * @date 2024/1/11
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int start = 0, end = 1;
        Map<Character, Integer> set = new HashMap();
        set.put(s.charAt(start), start);
        int longest = 1;
        while (start < end && end < s.length()) {
            Character ec = s.charAt(end);
            if (set.containsKey(ec)) {
                int dupIndex = set.get(ec);
                for (int i = start; i <= dupIndex; i++) {
                    set.remove(s.charAt(i));
                }
                start = dupIndex + 1;
            }
            set.put(s.charAt(end), end);
            end++;
            longest = Math.max(longest, end - start);
        }
        return longest;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring l = new LengthOfLongestSubstring();
        System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
    }
}
