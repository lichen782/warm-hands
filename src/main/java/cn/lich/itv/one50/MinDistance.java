package cn.lich.itv.one50;

/**
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 * <p>
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *
 * @author lich
 * @date 2024/2/25
 */
public class MinDistance {

    public int minDistance(String word1, String word2) {
        if (word1.length() == 0 || word2.length() == 0) {
            return word1.length() != 0 ? word1.length() : word2.length();
        }
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                dp[i][j] = dp[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1); // 替换或者不替换，取决于最后一个字符是否相等
                dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j]); // 从 i - 1 到 j，最后一个字符删除
                dp[i][j] = Math.min(dp[i][j - 1] + 1, dp[i][j]); // 从 i 到 j - 1，添加一个字符
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        MinDistance m = new MinDistance();
        String word1 = "pneumonoultramicroscopicsilicovolcanoconiosis", word2 = "ultramicroscopically";
        System.out.println(m.minDistance(word1, word2));
    }
}
