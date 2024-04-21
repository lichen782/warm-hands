package cn.lich.itv.one50;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 *
 * @author lich
 * @date 2023/12/30
 */
public class CanJump {

    public boolean canJump(int[] nums) {
        // result: dp[i] from i to nums.length - 1
        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;
        for (int i = nums.length - 1; i >= 0 ; i--) {
            // for dp[i] = true iff
            // exist k where
            for (int k = 0; k < nums.length - i; k++) {
                if (dp[i + k] && nums[i] >= k) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        CanJump cj = new CanJump();
        int[] nums = {3,2,1,0,4};
        System.out.println(cj.canJump(nums));
    }
}
