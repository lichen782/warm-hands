package cn.lich.itv.one50;

/**
 *
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * @author lich
 * @date 2024/2/23
 */
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length]; // dp[i]: 以nums[i]结尾的递增子序列长度

        // dp[i] = Max: dp[j] + 1 where 0 <= j < i and nums[j] < nums[i]
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        LengthOfLIS l = new LengthOfLIS();
        int[] nums = {7,7,7,7,7,7,7};
        System.out.println(l.lengthOfLIS(nums));
    }
}
