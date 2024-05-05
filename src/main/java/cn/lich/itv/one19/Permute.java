package cn.lich.itv.one19;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个不含重复数字的整数数组 nums ，返回其 所有可能的全排列 。可以 按任意顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 *
 * @author lich
 * @date 2024/5/4
 */
public class Permute {

    private int[] nums;

    private Set<Integer> visited;

    private LinkedList<Integer> path;

    private List<List<Integer>> ans;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.ans = new ArrayList<>();
        this.visited = new HashSet<>();
        this.path = new LinkedList<>();

        dfs();

        return ans;

    }

    private void dfs() {
        if (this.path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited.contains(i)) {
                visited.add(i);
                path.add(nums[i]);
                dfs();
                visited.remove(i);
                path.removeLast();
            }
        }
    }

    public static void main(String[] arg) {
        Permute p = new Permute();
        int[] nums = {1,2,3};
        List<List<Integer>> ans = p.permute(nums);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(String.join(",", ans.get(i).stream().map(String::valueOf).collect(Collectors.toList())));
        }
    }
}
