package cn.lich.itv.one19;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断它们是不是一组变位词（字母异位词）。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同且字符顺序不完全相同，则称 s 和 t 互为变位词（字母异位词）。
 * @author lich
 * @date 2024/3/30
 */
public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.equals(t) || s.length() != t.length()) {
            return false;
        }
        return Arrays.equals(counter(s), counter(t));
    }

    private int[] counter(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int offset = s.charAt(i) - 'a';
            count[offset]++;
        }
        return count;
    }
}
