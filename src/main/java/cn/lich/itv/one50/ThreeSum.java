package cn.lich.itv.one50;

import java.util.*;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 示例 2：
 *
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 示例 3：
 *
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 *
 * @author lich
 * @date 2024/1/10
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        List<List<Integer>> rt = new ArrayList<>();

        Set<String> triples = new HashSet<>();

        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;
            int target = -nums[i];
            while (j < k) {
                int sum = nums[j] + nums[k];
                if (sum > target) {
                    k--;
                    continue;
                } else if (sum < target) {
                    j++;
                    continue;
                } else if (!triples.contains(getTripleKey(nums[i], nums[j], nums[k]))){
                    List<Integer> ar = new ArrayList<>();
                    ar.add(nums[i]);
                    ar.add(nums[j]);
                    ar.add(nums[k]);
                    rt.add(ar);
                    triples.add(getTripleKey(nums[i], nums[j], nums[k]));
                }
                j++;
                k--;
            }
        }

        return rt;
    }

    private String getTripleKey(int i, int j, int k) {
        return String.join("-", String.valueOf(i), String.valueOf(j), String.valueOf(k));
    }

    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        int[] nums = {3,0,-2,-1,1,2};
        List<List<Integer>> l = ts.threeSum(nums);
        for (List<Integer> ll: l) {
            System.out.print("[");
            for (Integer i: ll) {
                System.out.print(i + ",");
            }
            System.out.print("]");
            System.out.println();
        }
    }
}
