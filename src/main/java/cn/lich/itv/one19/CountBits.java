package cn.lich.itv.one19;

/**
 * 给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。
 *
 *
 *
 * 示例 1:
 *
 * 输入: n = 2
 * 输出: [0,1,1]
 * 解释:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 示例 2:
 *
 * 输入: n = 5
 * 输出: [0,1,1,2,1,2]
 * 解释:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 *
 *
 * 说明 :
 *
 * 0 <= n <= 105
 * @author lich
 * @date 2024/3/12
 */
public class CountBits {

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0;

        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + ((i & 1) == 1 ? 1 : 0);
        }

        return ans;
    }

    public static void main(String[] args) {
        CountBits c = new CountBits();
        int[] ans = c.countBits(5);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + ", ");
        }
    }
}
