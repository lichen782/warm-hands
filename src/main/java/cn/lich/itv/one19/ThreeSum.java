package cn.lich.itv.one19;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？请找出所有和为 0 且 不重复 的三元组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 *
 * @author lich
 * @date 2024/3/14
 */
public class ThreeSum {

    private Map<Integer, Set<Integer>> dedup;

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }

        dedup = new HashMap<>();

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            findTarget(nums, i + 1, nums.length - 1, 0 - nums[i], ans);
        }

        return ans;

    }

    private void findTarget(int[] nums, int low, int high, int target, List<List<Integer>> ans) {
        while (low < high) {
            int sum = nums[low] + nums[high];
            if (sum > target) {
                high--;
            } else if (sum < target) {
                low++;
            } else {
                boolean drop = dedup.containsKey(-target) && dedup.get(-target).contains(nums[low]);
                if (!drop) {
                    List<Integer> r = new ArrayList<>();
                    r.add(-target);
                    r.add(nums[low]);
                    r.add(nums[high]);
                    ans.add(r);
                    if (!dedup.containsKey(-target)) {
                        dedup.put(-target, new HashSet<>());
                    }
                    dedup.get(-target).add(nums[low]);
                }
                low++;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        ThreeSum t = new ThreeSum();
        int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        List<List<Integer>> l = t.threeSum(nums);
        for (List<Integer> ll: l) {
            System.out.println(String.join(",", ll.stream().map(String::valueOf).collect(Collectors.toList())));
        }
    }
}
