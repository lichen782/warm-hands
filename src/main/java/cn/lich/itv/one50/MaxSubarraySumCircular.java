package cn.lich.itv.one50;

/**
 * 给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。
 * <p>
 * 环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。
 * <p>
 * 子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。
 *
 * @author lich
 * @date 2024/2/8
 */
public class MaxSubarraySumCircular {

    public int maxSubarraySumCircular(int[] nums) {
        int preMax = nums[0];
        int max = nums[0];
        int preMin = nums[0];
        int min = nums[0];
        int totalSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preMax = Math.max(preMax + nums[i], nums[i]);
            max = Math.max(max, preMax);
            preMin = Math.min(preMin + nums[i], nums[i]);
            min = Math.min(min, preMin);
            totalSum += nums[i];
        }

        if (max < 0) {
            return max;
        }

        return Math.max(max, totalSum - min);
    }


    public static void main(String[] args) {
        MaxSubarraySumCircular m = new MaxSubarraySumCircular();
        int[][] nums =
                {
                        {1, -2, 3, -2},
                        {5, -3, 5},
                        {3, -2, 2, -3},
                        {-9, -10, -1}
                };
        for (int[] num: nums) {
            int ans = m.maxSubarraySumCircular(num);
            System.out.println(ans);
        }
    }
}
