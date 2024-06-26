package cn.lich.itv.one19;

/**
 * 如果一个由 '0' 和 '1' 组成的字符串，是以一些 '0'（可能没有 '0'）后面跟着一些 '1'（也可能没有 '1'）的形式组成的，那么该字符串是 单调递增 的。
 *
 * 我们给出一个由字符 '0' 和 '1' 组成的字符串 s，我们可以将任何 '0' 翻转为 '1' 或者将 '1' 翻转为 '0'。
 *
 * 返回使 s 单调递增 的最小翻转次数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "00110"
 * 输出：1
 * 解释：我们翻转最后一位得到 00111.
 * 示例 2：
 *
 * 输入：s = "010110"
 * 输出：2
 * 解释：我们翻转得到 011111，或者是 000111。
 * 示例 3：
 *
 * 输入：s = "00011000"
 * 输出：2
 * 解释：我们翻转得到 00000000。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 20000
 * s 中只包含字符 '0' 和 '1'
 * @author lich
 * @date 2024/5/10
 */
public class MinFlipsMonoIncr {

    public int minFlipsMonoIncr(String s) {
        int[] oneBefore = new int[s.length() + 1];
        int[] zeroAfter = new int[s.length()];

        for (int i = 1; i <= s.length(); i++) {
            oneBefore[i] = oneBefore[i - 1] + (s.charAt(i - 1) == '1' ? 1 : 0);
        }

        for (int i = s.length() - 2; i >= 0; i--) {
            zeroAfter[i] = zeroAfter[i + 1] + (s.charAt(i + 1) == '0' ? 1 : 0);
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            ans = Math.min(oneBefore[i] + zeroAfter[i], ans);
        }

        return ans;
    }

    public static void main(String[] args) {
        MinFlipsMonoIncr m = new MinFlipsMonoIncr();
        String s = "111110";
        System.out.println(m.minFlipsMonoIncr(s));
    }
}
