package cn.lich.itv.one19;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
 * 示例 2：
 *
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 * @author lich
 * @date 2024/3/17
 */
public class FindMaxLength {

    public int findMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        int maxLen = 0;
        int counter = 0;

        Map<Integer, Integer> m = new HashMap<>();

        m.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                counter++;
            } else {
                counter--;
            }
            if (m.containsKey(counter)) {
                Integer preIndex =m.get(counter);
                maxLen = Math.max(i - preIndex, maxLen);
            } else {
                m.put(counter, i);
            }

        }
        return maxLen;
    }

    public static void main(String[] args) {
        FindMaxLength f = new FindMaxLength();
        int[] nums = {0,0,1,0,0,0,1,1};
        System.out.println(f.findMaxLength(nums));
    }
}
