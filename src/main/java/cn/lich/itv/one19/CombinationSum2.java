package cn.lich.itv.one19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个可能有重复数字的整数数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次，解集不能包含重复的组合。
 *
 *
 *
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 *
 * 提示:
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 *
 * @author lich
 * @date 2024/5/4
 */
public class CombinationSum2 {

    private int[] candidates;

    private List<List<Integer>> ans;

    private LinkedList<Integer> path;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        Arrays.sort(this.candidates);

        this.ans = new ArrayList<>();
        this.path = new LinkedList<>();

        dfs(-1, target);

        return this.ans;
    }

    private void dfs(int from, int target) {
        if (target <= 0) {
            if (target == 0) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = from + 1; i < candidates.length; i++) {
            if (i > from + 1 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);

            dfs(i, target - candidates[i]);

            path.removeLast();
        }
    }

    public static void main(String[] args) {
        CombinationSum2 cs = new CombinationSum2();
        int[] candidate = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> ans = cs.combinationSum2(candidate, target);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(String.join(",", ans.get(i).stream().map(String::valueOf).collect(Collectors.toList())));
        }
    }
}
