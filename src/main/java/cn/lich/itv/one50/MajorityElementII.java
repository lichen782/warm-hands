package cn.lich.itv.one50;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/majority-element-ii/
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,2,3]
 * 输出：[3]
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：[1]
 * 示例 3：
 *
 * 输入：nums = [1,2]
 * 输出：[1,2]
 *
 *
 * 1, 9, 4, 0, 1, 3, 1, 1
 * n: 1 9  4 0  1 3 1 -
 * c: 1 1  1 1  1 1 2 0
 *
 * 3, 2, 3
 * n: - -   3 -   3 2   3 2
 * c: 0 0   1 -   1 1   2 1
 *
 * 1, 2
 * n: 1 2
 * c: 1 1
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
 * @author lich
 * @date 2023/8/26
 */
public class MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> l = new LinkedList<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!count.containsKey(nums[i])) {
                count.put(nums[i], 0);
            }

            count.put(nums[i], count.get(nums[i]) + 1);
        }

        int threshold = nums.length / 3;

        for (Integer integer : count.keySet()) {
            if (count.get(integer) > threshold) {
                l.add(integer);
            }
        }
        return l;
    }

    public static void main(String[] args) {
        MajorityElementII m = new MajorityElementII();
        List<Integer> l = m.majorityElement(new int[]{3,2,3});
        for (Integer integer : l) {
            System.out.print(integer + ", ");
        }
    }
}
