package cn.lich.itv.one50;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 * @author lich
 * @date 2024/2/7
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int curMax = Integer.MIN_VALUE;
        int acc = 0;

        for (int i = 0; i < nums.length; i++) {
            if (acc < 0 || acc + nums[i] < 0) {
                acc = nums[i];
            } else {
                acc += nums[i];
            }

            curMax = Math.max(curMax, acc);
        }

        return curMax;
    }

    public static void main(String[] args) {
        MaxSubArray m = new MaxSubArray();
        int[] nums = { -1 };
        System.out.println(m.maxSubArray(nums));
    }
}
