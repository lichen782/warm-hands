package cn.lich.itv.one50;

/**
 * 最长回文子串
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * @author lich
 * @date 2024/2/24
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        char[] cs = s.toCharArray();

        boolean[][] dp = new boolean[cs.length][cs.length];

        int maxLenSt = 0;
        int maxLenEnd = 0;

        for (int i = cs.length - 1; i >= 0 ; i--) {
            for (int j = i; j < cs.length; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = cs[i] == cs[j] && (j - i == 1 || dp[i + 1][j - 1]);
                }
                if (dp[i][j] && j - i + 1 > maxLenEnd - maxLenSt + 1) {
                    maxLenSt = i;
                    maxLenEnd = j;
                }
            }
        }
        return s.substring(maxLenSt, maxLenEnd + 1);
    }

    public static void main(String[] args) {
        LongestPalindrome l = new LongestPalindrome();
        System.out.println(l.longestPalindrome("cbbd"));
    }
}
