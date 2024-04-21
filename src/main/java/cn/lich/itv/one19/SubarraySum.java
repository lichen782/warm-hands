package cn.lich.itv.one19;

/**
 * @author lich
 * @date 2024/3/15
 */
public class SubarraySum {

    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];

        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= nums.length; j++) {
                if (sum[j] - sum[i] == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SubarraySum s = new SubarraySum();
        int[] nums = {1, 2, 3};
        System.out.println(s.subarraySum(nums, 3));
    }
}
