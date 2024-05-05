package cn.lich.itv.one19;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个可包含重复数字的整数集合 nums ，按任意顺序 返回它所有不重复的全排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 *
 * @author lich
 * @date 2024/5/4
 */
public class PermuteUnique {

    private int[] nums;

    private LinkedHashSet<Integer> path;

    private List<List<Integer>> ans;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        Arrays.sort(this.nums);

        this.ans = new ArrayList<>();
        this.path = new LinkedHashSet<>();

        dfs();

        return ans;

    }

    private void dfs() {
        if (this.path.size() == nums.length) {
            ans.add(path.stream().map(i -> nums[i]).collect(Collectors.toList()));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!path.contains(i)) {
                if (i > 0 && nums[i] == nums[i - 1] && !path.contains(i - 1)) {
                    continue;
                }
                path.add(i);
                dfs();
                path.remove(i);
            }
        }
    }

    public static void main(String[] arg) {
        PermuteUnique p = new PermuteUnique();
        int[] nums = {1,2,3};
        List<List<Integer>> ans = p.permuteUnique(nums);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(String.join(",", ans.get(i).stream().map(String::valueOf).collect(Collectors.toList())));
        }
    }
}
