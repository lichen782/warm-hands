package cn.lich.itv.one19;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 *
 * 提示：
 *
 * 1 <= k <= nums.length <= 104
 * -104 <= nums[i] <= 104
 *
 * @author lich
 * @date 2024/4/29
 */
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(
                Comparator.comparingInt(i -> nums[i])
        );

        for (int i = 0; i < nums.length; i++) {
            if (q.size() < k) {
                q.add(i);
            } else {
                if (nums[q.peek()] < nums[i]) {
                    q.remove();
                    q.add(i);
                }
            }
        }
        return nums[q.peek()];
    }

    public static void main(String[] args) {
        FindKthLargest f = new FindKthLargest();
        int[] nums = {3,2,1,5,6,4};
        System.out.println(f.findKthLargest(nums, 2));
    }
}
