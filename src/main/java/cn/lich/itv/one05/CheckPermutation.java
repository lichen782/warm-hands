package cn.lich.itv.one05;

import java.util.Arrays;

/**
 * 给定两个由小写字母组成的字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * 示例 1：
 *
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 *
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 *
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 * @author lich
 * @date 2024/3/9
 */
public class CheckPermutation {

    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] counter = getCounter(s1);
        for (int i = 0; i < s2.length(); i++) {
            if (counter[s2.charAt(i) - 'a'] > 0) {
                counter[s2.charAt(i) - 'a']--;
            } else {
                return false;
            }
        }
        return Arrays.stream(counter).allMatch(i -> i==0);
    }

    private int[] getCounter(String s1) {
        int[] counter = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            counter[s1.charAt(i) - 'a']++;
        }
        return counter;
    }

    public static void main(String[] args) {
        CheckPermutation c = new CheckPermutation();
        System.out.println(c.CheckPermutation("aba", "cba"));
    }
}
