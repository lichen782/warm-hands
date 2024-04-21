package cn.lich.itv.one19;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 *
 * 如果存在则返回 true，不存在返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1], k = 3, t = 0
 * 输出：true
 * 示例 2：
 *
 * 输入：nums = [1,0,1,1], k = 1, t = 2
 * 输出：true
 * 示例 3：
 *
 * 输入：nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出：false
 *
 *
 * 提示：
 *
 * 0 <= nums.length <= 2 * 104
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 104
 * 0 <= t <= 231 - 1
 *
 *
 * 注意：本题与主站 220 题相同： https://leetcode-cn.com/problems/contains-duplicate-iii/
 *
 * @author lich
 * @date 2024/4/9
 */
public class ContainsNearbyAlmostDuplicate {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Long, Integer> m = new HashMap<>();
        int w = t + 1;
        for (int i = 0; i < nums.length; i++) {
            long bucketId = getBucketId(nums[i], w);
            if (m.containsKey(bucketId)) {
                return true;
            }

            if (m.containsKey(bucketId - 1)) {
                int p = m.get(bucketId - 1);
                if (Math.abs(p - nums[i]) < w) {
                    return true;
                }
            }

            if (m.containsKey(bucketId + 1)) {
                int p = m.get(bucketId + 1);
                if (Math.abs(p - nums[i]) < w) {
                    return true;
                }
            }

            m.put(bucketId, nums[i]);

            if (i >= k) {
                m.remove(getBucketId(nums[i - k], w));
            }
        }
        return false;
    }

    private long getBucketId(long n, long w) {
        if (n >= 0) {
            return n / w;
        }
        return (n + 1) / w - 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,9,1,5,9};
        ContainsNearbyAlmostDuplicate c = new ContainsNearbyAlmostDuplicate();
        int k = 2, t = 3;
        System.out.println(c.containsNearbyAlmostDuplicate(nums, k, t));
    }
}
