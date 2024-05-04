package cn.lich.itv.one19;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 *
 * @author lich
 * @date 2024/5/4
 */
public class SubSet {

    public List<List<Integer>> subsets(int[] nums) {
        int len = (int)Math.pow(2, nums.length);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            List<Integer> l = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (((i >> j) & 1) != 0) {
                    l.add(nums[j]);
                }
            }
            ans.add(l);
        }
        return ans;
    }

    public static void main(String[] args) {
        SubSet s = new SubSet();
        int[] nums = {1,2,3};
        List<List<Integer>> ans = s.subsets(nums);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(String.join(",", ans.get(i).stream().map(String::valueOf).collect(Collectors.toList())));
        }
    }

}
