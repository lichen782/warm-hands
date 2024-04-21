package cn.lich.itv.one19;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 *
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 *
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 * @author lich
 * @date 2024/3/14
 */
public class MinSubArrayLen {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 1;

        int minLen = Integer.MAX_VALUE;
        int curSum = nums[left];

        while (right <= nums.length) {
            if (curSum < target) {
                if (right == nums.length) {
                    break;
                }
                curSum += nums[right++];
            } else {
                while (left < right && curSum >= target) {
                    minLen = Math.min(minLen, right - left);
                    curSum -= nums[left];
                    left++;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        MinSubArrayLen m = new MinSubArrayLen();
        int target = 11;
        int[] nums = {1,1,1,1,1,1,1,1};
        System.out.println(m.minSubArrayLen(target, nums));
    }

}
