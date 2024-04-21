package cn.lich.itv.one19;

/**
 * 给定一个字符串 s ，请计算这个字符串中有多少个回文子字符串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 * 示例 2：
 *
 * 输入：s = "aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 由小写英文字母组成
 * @author lich
 * @date 2024/3/24
 */
public class CountSubstrings {

    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        int sum = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (i == j) {
                    dp[i][j] = true;
                    sum++;
                    continue;
                }
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i == 1 || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        CountSubstrings c = new CountSubstrings();
        String s = "aaa";
        System.out.println(c.countSubstrings(s));
    }
}
